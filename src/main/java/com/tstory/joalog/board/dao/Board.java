package com.tstory.joalog.board.dao;


public class Board {

	private int id;
	private String fileAttach;
	private String privateSet;
	private String notice;
	private String reply;
	private String comments;
	private String replyComment;
	private String name;
	private String style;
	private String listStyle;
	private String category1;
	private String category2;
	private String etcOption;
	
	
	@Override
	public String toString(){
		return "[board]{ id:"+id+" | fileAttach:"+fileAttach+" | notice:"+notice
				+" | reply:"+reply+" | comments:"+comments+" | replyComment:"+replyComment
				+" | name:"+name+" | style:"+style+" | listStyle:"+listStyle
				+" | etcOption:"+etcOption+" }";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(String fileAttach) {
		this.fileAttach = fileAttach;
	}
	
	public String getPrivateSet() {
		return privateSet;
	}

	public void setPrivateSet(String privateSet) {
		this.privateSet = privateSet;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getReplycomment() {
		return replyComment;
	}

	public void setReplycomment(String replyComment) {
		this.replyComment = replyComment;
	}
	
	public String getReplyComment() {
		return replyComment;
	}
	
	public void setReply_comment(String replyComment) {
		this.replyComment = replyComment;
	}
	
	public String getReply_comment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getListStyle() {
		return listStyle;
	}

	public void setListStyle(String listStyle) {
		this.listStyle = listStyle;
	}

	
	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getEtcOption() {
		return etcOption;
	}

	public void setEtcOption(String etcOption) {
		this.etcOption = etcOption;
	}


	
}
