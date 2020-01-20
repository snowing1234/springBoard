package com.tstory.joalog.post.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.board.service.BoardServiceImpl;
import com.tstory.joalog.post.dao.Post;
import com.tstory.joalog.post.service.PostServiceImpl;


@Controller
@RequestMapping("/post")
public class PostController {
	
	@Inject
	private BoardServiceImpl boardService;
	
	@Inject
	private PostServiceImpl service;
	/*********************************** link *********************************************/
	

	
	@RequestMapping(value="/{boardId}/{postId}/view", method=RequestMethod.GET)
	public ModelAndView view(ModelAndView mv, HttpSession session, @PathVariable int boardId, @PathVariable String postId){
		mv.addObject("board", boardService.select(boardId));
		return service.view(mv, session, boardId, postId);
	}
	
	@RequestMapping(value="/{boardId}/insert", method=RequestMethod.GET)
	public String insert(Model model, @PathVariable int boardId){
		return "post/insert.basic";
	}
	
	@RequestMapping(value="/{boardId}/{postId}/update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView mv, HttpSession session, @PathVariable int boardId, @PathVariable int postId){
		return service.updateGet(mv, session, boardId, postId);
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
	public @ResponseBody String deletePrss(Model model,  @PathVariable int boardId,  @PathVariable int postId) {
		return service.delete(boardId, postId);
	}
	
	
}
