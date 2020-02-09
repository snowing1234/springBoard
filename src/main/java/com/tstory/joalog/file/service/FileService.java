package com.tstory.joalog.file.service;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tstory.joalog.file.dao.FileDAO;
import com.tstory.joalog.file.dao.FileInfo;

@Service("FileService")
public class FileService  {
	
	@Inject
	private FileDAO dao;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	public String  upload(MultipartFile file, FileInfo fileInfo) throws Exception {
		
		String groupId = fileInfo.getGroupId();
		String fileUploadPath = uploadPath +"/"+groupId;
		//경로 생성
		if ( ! new File(fileUploadPath).exists()) {
			new File(fileUploadPath).mkdir();
			dao.insertGroupId(groupId);
		}
		//업로드
		String result = "ERROR";
		String savedName = uploadFile(fileUploadPath, file.getOriginalFilename(), file);
		if (! savedName.equals("")) { 
			fileInfo.setFilenameServer(savedName);
			result = insertFileInfo(fileInfo);
		}
		//이미지 - 썸네일생성
		if (result.equals("SUCCESS") && groupId.equals("image")) {
			uploadThumbNail(fileUploadPath, fileInfo.getFilenameServer());
		}
		return result;
	}
	
	private String uploadFile(String fileUploadPath, String OriginalFileName, MultipartFile tempFile){
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_"+OriginalFileName;
		File target = new File(fileUploadPath, savedName);
		
		try {
			FileCopyUtils.copy(tempFile.getBytes(), target);
		} catch(Exception e){
			return null;
		}
		return savedName;
	}
	
	private String uploadThumbNail (String fileUploadPath, String savedName) throws IOException  {
		 //이미지 사이즈  변환
		 BufferedImage thumbImage = Scalr.resize(
					 ImageIO.read(new File(fileUploadPath, savedName)),
					 Scalr.Method.AUTOMATIC, 
					 Scalr.Mode.FIT_TO_HEIGHT,
					 100
				 );
		 
		 //썸네일 이미지 저장
		 String extension = FilenameUtils.getExtension(savedName);
		 String fileName = "/s_"+savedName;
		 ImageIO.write(thumbImage,  extension, new File(fileUploadPath + fileName));
		
		 return fileName;
	}
	
	private String insertFileInfo(FileInfo fileInfo){
		try {
			dao.insertFileInfo(fileInfo);
		    dao.updateFilePathCount(fileInfo.getGroupId());
		    return "SUCCESS";
		} catch(Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	//file, session, boardId, postId
	public FileInfo setFileInfo(MultipartFile mpfile, String writer, int boardId, int postId, String ip) {
	    FileInfo fileInfo = new FileInfo();
		fileInfo.setAttacher(writer);
		fileInfo.setBoardId(boardId);
		fileInfo.setFileExtension(FilenameUtils.getExtension(mpfile.getOriginalFilename()));
		fileInfo.setFilenameReal(mpfile.getOriginalFilename());
		fileInfo.setFileSize(mpfile.getSize());
		fileInfo.setGroupId(mpfile.getContentType().split("/")[0]);
		fileInfo.setIp(ip);
		fileInfo.setPostId(postId);
	    return fileInfo;
	}
	
	
	//게시글의 첨부파일 읽기
	public List<FileInfo> selectFiles(int boardId, int postId) {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setBoardId(boardId);
		fileInfo.setPostId(postId);
		return dao.selectFileInfos(fileInfo);
	}
	
	public String checkLogin(HttpSession session) throws Exception{
		Object loginID = session.getAttribute("MYBOARD_MEMBER");
		if ((loginID) == null || (loginID.toString().equals(""))) {
			throw new Exception("ERROR_NOT_LOGIN");
		}
		return (String) loginID;
	}
	
	public  String getClientIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	 
	    return ip;
	}

	public boolean  fileDownLoad(HttpServletRequest request, HttpServletResponse response, int boardId, int postId) throws IOException {
		
		//기본 ajax요청 시 응답
		String filenameReal = request.getParameter("FileName");
		if (filenameReal == null || filenameReal.equals("")) {
			return false;
		}
		
		//요청파일 정보 불러오기
		FileInfo fileInfo = new FileInfo();
		fileInfo.setBoardId(boardId);
		fileInfo.setPostId(postId);
		fileInfo.setFilenameReal(filenameReal);
		fileInfo = dao.selectFileInfo(fileInfo);
		
		//ContentType설정
		if (fileInfo.getGroupId().equals("image")) {
			response.setContentType(MediaType.MULTIPART_FORM_DATA);
		}else {
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		}
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(filenameReal,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일읽어 응답하기
		byte[] fileByte = FileUtils.readFileToByteArray(new File(uploadPath + "/" +fileInfo.getGroupId() + "/" +  fileInfo.getFilenameServer()));
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
	    response.getOutputStream().close();
	    
	    return true;
	}

	public String delete(int boardId, int postId) {
		 List<FileInfo> files = selectFiles(boardId, postId);
		 for (int idx=0 ; idx < files.size() ; idx ++){
			 deleteFile(files.get(idx), boardId, postId);
		 }
		return "SUCCESS";
	}
	

	public boolean fileDelete(HttpServletRequest request, HttpServletResponse response, int boardId, int postId) throws IOException {
		//기본 ajax요청 시 응답
		String filenameReal = request.getParameter("FileName");
		if (filenameReal == null || filenameReal.equals("")) {
			return false;
		}
		
		//요청파일 정보 불러오기
		FileInfo fileInfo = new FileInfo();
		fileInfo.setBoardId(boardId);
		fileInfo.setPostId(postId);
		fileInfo.setFilenameReal(filenameReal);
		fileInfo = dao.selectFileInfo(fileInfo);
		
		deleteFile(fileInfo, boardId, postId);
		dao.deleteFile(fileInfo);
	    return true;
		
	}
	
	public void deleteFile(FileInfo fileInfo, int boardId, int postId) {
		 String fileName = fileInfo.getFilenameServer();
		 String fileUploadPath =uploadPath + "/" +fileInfo.getGroupId();
		 
		 //파일 삭제
		new File(fileUploadPath, fileName).delete();
		
		//이미지 - 썸네일 삭제
		if ( (fileInfo.getGroupId()).equals("image")) {
			new File(fileUploadPath, "s_" + fileName).delete();
		}
		dao.deleteFile(fileInfo);
}
}
