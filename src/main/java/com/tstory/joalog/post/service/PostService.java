package com.tstory.joalog.post.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.post.dao.Post;


public interface PostService {
	public String insert(HttpServletRequest request, HttpSession session, Post dao);
	public ModelAndView view(ModelAndView mv, HttpSession session, int boardId, String postId);
	public Post select(String id);
	public String delete(HttpSession session, int boardId, int postId);
	public ModelAndView updateGet(ModelAndView mv, HttpSession session, int boardId, int postId);
	public String update(HttpServletRequest request, HttpSession session, int boardId, int postId);
	
	public ModelAndView list(ModelAndView mv, int boardId, int page, int listnum);
}
