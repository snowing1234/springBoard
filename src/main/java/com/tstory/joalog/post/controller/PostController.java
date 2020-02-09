package com.tstory.joalog.post.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.board.service.BoardServiceImpl;
import com.tstory.joalog.file.dao.FileInfo;
import com.tstory.joalog.file.service.FileService;
import com.tstory.joalog.post.dao.Post;
import com.tstory.joalog.post.service.PostServiceImpl;


@Controller
@RequestMapping("/post")
public class PostController {
	
	@Inject
	private BoardServiceImpl boardService;
	
	@Inject
	private PostServiceImpl service;
	
	@Inject
	private FileService fileService;
	
	/*********************************** link *********************************************/
	
	@RequestMapping(value="/{boardId}/{postId}/view", method=RequestMethod.GET)
	public ModelAndView view(ModelAndView mv, HttpSession session, @PathVariable int boardId, @PathVariable int postId){
		mv.addObject("board", boardService.select(boardId));
		mv.addObject("files", fileService.selectFiles(boardId, postId));
		return service.view(mv, session, boardId, postId);
	}
	
	@RequestMapping(value="/{boardId}/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mv, @PathVariable int boardId){
		mv.addObject(boardId);
		mv.addObject("board", boardService.select(boardId));
		mv.setViewName("post/insert.basic");
		return mv;
	}
	
	@RequestMapping(value="/{boardId}/{postId}/update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView mv, HttpSession session, @PathVariable int boardId, @PathVariable int postId){
		mv = service.updateGet(mv, session, boardId, postId);
		mv.addObject("board", boardService.select(boardId));
		mv.addObject("files", fileService.selectFiles(boardId, postId));
		return mv;
	}
	
	/*********************************** process *********************************************/
//	@RequestMapping(value="/list/{boardId}", method=RequestMethod.GET)
//	public String list (Model model, @PathVariable("boardId") String boardId){
//		service.list(boardId, 1, 10);
//		return "post/list.basic";
//	}
	
	@RequestMapping(value="/{boardId}/list", method=RequestMethod.GET)
	public ModelAndView list (ModelAndView mv,  @PathVariable int boardId){  
		mv.addObject("board", boardService.select(boardId));
		return service.list(mv, boardId, 1, 5); 
	}
	
	@RequestMapping(value="/{boardId}/insert", method=RequestMethod.POST)
	public @ResponseBody String insertPrss(HttpServletRequest request, HttpSession session, Post vo,  @PathVariable int boardId) throws Exception{
		return service.insert(request, session, vo);
	}
	
	@RequestMapping(value="/{boardId}/{postId}/update", method=RequestMethod.POST) //updatePrss
	public @ResponseBody String updatePrss(HttpServletRequest request, HttpSession session,  @PathVariable int boardId, @PathVariable int postId){
		return service.update(request, session, boardId, postId);
	}
	
	@RequestMapping(value="/{boardId}/{postId}/delete", method=RequestMethod.GET) //deletePrss
	public @ResponseBody String deletePrss(Model model,   HttpSession session,  @PathVariable int boardId,  @PathVariable int postId) {
		String result = service.delete(session, boardId, postId);
		if (result.equals("SUCCESS")) {
			result = fileService.delete(boardId, postId);
		}
		return result;
	}
	
	@RequestMapping(value="/{boardId}/{postId}/fileInsert.do", method=RequestMethod.POST) 
	public @ResponseBody String fileupload(HttpServletRequest request, HttpSession session, MultipartFile file, @PathVariable int boardId, @PathVariable int postId) throws Exception {
		FileInfo fileInfo = fileService.setFileInfo(file, fileService.checkLogin(session), boardId, postId, fileService.getClientIpAddr(request));
		String result = fileService.upload(file, fileInfo);
		if (result.equals("SUCCESS")){
			service.updateFileCount(boardId, postId);
		}
		return result;
	}
	
   @RequestMapping(value="/{boardId}/{postId}/fileDownLoad", method=RequestMethod.GET) 
	public  void fileDownLoad(HttpServletRequest request, HttpServletResponse response, @PathVariable int boardId,  @PathVariable int postId) throws IOException {
		 fileService.fileDownLoad(request, response, boardId, postId);
   }
   
   @RequestMapping(value="/{boardId}/{postId}/fileDelete", method=RequestMethod.GET) 
	public  void fileDelete(HttpServletRequest request, HttpServletResponse response, @PathVariable int boardId,  @PathVariable int postId) throws IOException {
		 fileService.fileDelete(request, response, boardId, postId);
		 service.fileDelete(boardId, postId);
  }
	
	
}
