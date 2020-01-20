package com.tstory.joalog.board.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.board.dao.Board;
import com.tstory.joalog.board.service.BoardServiceImpl;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardServiceImpl service;
	
	/*********************************** link *********************************************/
	
	//게시판 리스트로 이동
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list (ModelAndView mv,  HttpSession session){
		//매니저 체크
		if ( service.isManager(session) == "SUCCESS") {
			// 리스트
			mv.addObject("list", service.list(1, 5));
			mv.setViewName("Amanager/board/list.basic");
		}else{
			mv.setViewName("info/main.basic");
		}
		return mv;
	}
	
	//게시작 생성페이지로 이동
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model, Board vo){
		return "Amanager/board/insert.basic";
	}
	
	//게시판 페이지로 이동
	@RequestMapping(value="{boardId}/update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView mv, @PathVariable int boardId){
		mv.addObject("board", service.select(boardId));
		mv.setViewName("Amanager/board/update.basic");
		return mv;
	}
	
	/*********************************** process *********************************************/
//	@RequestMapping(value="/list/{boardId}", method=RequestMethod.GET)
//	public String list (Model model, @PathVariable("boardId") String boardId){
//		service.list(boardId, 1, 10);
//		return "Amanager/board/list.basic";
//	}
	
	
	//게시판 생성
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody String insertPrss(HttpServletRequest request, HttpSession session, Board vo) {
		return service.insert(request, session, vo);
	}
	
	//게시판 정보 수정
	@RequestMapping(value="/update", method=RequestMethod.POST) //updatePrss
	public @ResponseBody String updatePrss(HttpServletRequest request, HttpSession session, Board vo){
		return service.update(request, session, vo);
	}
	
	//게시판 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST) //deletePrss
	public @ResponseBody String deletePrss(HttpServletRequest request, HttpSession session, @RequestBody Map<String, Object> params) {
		return service.delete(request, session, params);
	}
	
}
