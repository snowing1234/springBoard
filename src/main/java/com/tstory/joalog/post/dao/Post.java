package com.tstory.joalog.post.dao;

import java.sql.Date;

public class Post {

	private int boardId;
	private int postId;
	private String writer;
	private String writernick;
	private String title;
	private String content;
	private Date dateWrite;
	private Date dateUpdate;
	private String ip;
	private int hit;
	private int fileCnt;
	
	public Post(){
		
	}
	
	public Post(int boardId, int postId){
		setBoardId(boardId);
		setPostId(postId);
	}
	
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriternick() {
		return writernick;
	}

	public void setWriternick(String writernick) {
		this.writernick = writernick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateWrite() {
		return dateWrite;
	}

	public void setDateWrite(Date dateWrite) {
		this.dateWrite = dateWrite;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
	}

	@Override
	public String toString(){
		return "[post]{ boardId:"+boardId+ " | postId:"+postId +" | writer:"+writer +" | title:"+title +" | dateWrite:"+dateWrite+" | dateUpdate:"+dateUpdate +" | ip:"+ ip+" | hit:"+hit +" | fileCnt:"+fileCnt +" | content:"+content+" }";
	}
	
}
