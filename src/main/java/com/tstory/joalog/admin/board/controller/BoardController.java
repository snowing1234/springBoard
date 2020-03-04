package com.tstory.joalog.admin.board.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.admin.Admin;
import com.tstory.joalog.admin.board.dao.Board;
import com.tstory.joalog.admin.board.service.BoardServiceImpl;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardServiceImpl service;
	
	
	
	
	/*********************************** link *********************************************/
	
	
	
	
	//게시작 생성페이지로 이동
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model, HttpSession session){
		//매니저 체크
		if (Admin.checkAuth(session) != null) {
			return "info/main.basic";
		}
		return "Amanager/board/insert.basic";
	}
	
	//게시판 페이지로 이동
	@RequestMapping(value="{boardId}/update", method=RequestMethod.GET)
	public String update(ModelMap model, HttpSession session, @PathVariable int boardId){
		//매니저 체크
		if (Admin.checkAuth(session) != null) {
			return "info/main.basic";
		}
		
		model.addAttribute("board", service.select(boardId));
		return "Amanager/board/update.basic";
	}
	
	
	
	
	/*********************************** process *********************************************/

	
	//게시판 생성
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> insertPrss(HttpServletRequest request, HttpSession session, Board vo) {
		ResponseEntity<?> rspEntity = null;
		
		//매니저 체크
		if ((rspEntity = Admin.checkAuth(session)) != null) {
			return rspEntity;
		}
		
		return service.insert(request, session, vo); 
	}
	
	//게시판 정보 수정
	@RequestMapping(value="/update", method=RequestMethod.POST) //updatePrss
	public ResponseEntity<?>updatePrss(HttpServletRequest request, HttpSession session, Board vo){
		ResponseEntity<?> rspEntity = null;
		
		//매니저 체크
		if ((rspEntity = Admin.checkAuth(session)) != null) {
			return rspEntity;
		}
		
		return service.update(request, session, vo);
	}
	
	//게시판 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST) //deletePrss
	public ResponseEntity<?> deletePrss(HttpServletRequest request, HttpSession session, @RequestBody Map<String, Object> params) {
		ResponseEntity<?> rspEntity = null;
		
		//매니저 체크
		if ((rspEntity = Admin.checkAuth(session)) != null) {
			return rspEntity;
		}
		
		return service.delete(request, session, params);
	}
	
	
	//게시판 리스트
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list (ModelMap model, HttpSession session){
		//매니저 체크
		if (Admin.checkAuth(session) == null) {
			// 리스트
			model.addAttribute("list", service.list(1, 5));
			return "Amanager/board/list.basic";
			
		}else{
			return "info/main.basic";
		}
	}
	
}
