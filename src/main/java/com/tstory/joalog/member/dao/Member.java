package com.tstory.joalog.member.dao;

import java.sql.Date;

public class Member {
	
	private String id;
	private String pw;
	private Date date_register;
	private String nickName;
	private boolean manager;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getDateRegister() {
		return date_register;
	}
	public void setDateRegister(Date date_register) {
		this.date_register = date_register;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString(){
		return "Member Info [ id:"+ id + ", pw:"+ pw + ", date_register:"+ date_register + ", nick:"+ nickName +"]";
	}
	
	
}
