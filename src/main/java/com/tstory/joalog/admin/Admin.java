package com.tstory.joalog.admin;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Admin {
	static public ResponseEntity<?> checkAuth(HttpSession session){
		ResponseEntity<?> rspEntity = null;
		if (session.getAttribute("MYBOARD_MEMBER") == null) {
			rspEntity = new ResponseEntity<>("please check login state", HttpStatus.BAD_REQUEST);
		} else if (!session.getAttribute("MYBOARD_ROLE").equals("MANAGER")){
			rspEntity = new ResponseEntity<>("only for manager", HttpStatus.BAD_REQUEST);
		}
		return rspEntity;
	}
}