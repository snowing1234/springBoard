package com.tstory.joalog.file.dao;

import java.sql.Date;

public class FileInfo {
	
	private int boardId;
	private int postId;
	private String groupId;
	private String filenameReal;
	private String filenameServer;
	private String fileExtension;
	private String attacher;
	private Date attachDate;
	private long FileSize;
	private String ip;
	
	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getFilenameReal() {
		return filenameReal;
	}


	public void setFilenameReal(String filenameReal) {
		this.filenameReal = filenameReal;
	}


	public String getFilenameServer() {
		return filenameServer;
	}


	public void setFilenameServer(String filenameServer) {
		this.filenameServer = filenameServer;
	}


	public String getFileExtension() {
		return fileExtension;
	}


	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}


	public String getAttacher() {
		return attacher;
	}


	public void setAttacher(String attacher) {
		this.attacher = attacher;
	}


	public Date getAttachDate() {
		return attachDate;
	}


	public void setAttachDate(Date attachDate) {
		this.attachDate = attachDate;
	}


	public long getFileSize() {
		return FileSize;
	}


	public void setFileSize(long fileSize) {
		FileSize = fileSize;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString(){
		return "Member Info [ "
				+ "boardId:"+ boardId 
				+ ", postId:"+ postId 
				+ ", groupId:"+ groupId 
				+ ", filenameReal:"+ filenameReal
				+ ", filenameServer:"+ filenameServer
				+ ", fileExtension:"+ fileExtension
				+ ", attacher:"+ attacher
				+ ", attachDate:"+ attachDate
				+ ", FileSize:"+ FileSize
				+ ", ip:"+ ip
				+"]";
	}
	
	
}
