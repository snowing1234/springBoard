package com.tstory.joalog.post.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.member.dao.MemberUtil;
import com.tstory.joalog.page.DefaultPage;
import com.tstory.joalog.post.dao.Post;
import com.tstory.joalog.post.dao.PostDAOImpl;

@Service("PostService")
public class PostServiceImpl implements PostService {

	@Inject
	private PostDAOImpl dao;
	
	@Override
	public String insert(HttpServletRequest request, HttpSession session, Post vo) {
		try {
			vo.setWriter(CheckLogin(session));
			vo.setIp(MemberUtil.getIp(request));
			dao.insert(vo);
		} catch (Exception e) {
			return "ERROR"+e.getMessage();
		}
		return "SUCCESS";
	}

	@Override
	public Post select(String id) {
		
		return null;
	}

	@Override
	public String delete(int boardId, int postId) {
		dao.delete(boardId, postId);
		return "SUCCESS";
	}

	@Override
	public ModelAndView updateGet(ModelAndView mv, HttpSession session, int boardId, int postId) {
		try {
			String loginId = CheckLogin(session);
			Post post = dao.get(boardId, postId);
			if ( ! loginId.equals(post.getWriter())) {
				throw new Exception("NOT_HAVE_PRIVILIAGE");
			}
		} catch (Exception e) {
			mv.setViewName("post/list.basic");
		}
		mv.addObject("post", dao.get(boardId, postId));
		mv.setViewName("post/update.basic");
		return mv;
	}
	
	@Override
	public String update(HttpServletRequest request, HttpSession session, int boardId, int postId){
		try {
			Post post = dao.get(boardId, postId);
			if (post.getWriter().equals(CheckLogin(session))) {
				post.setTitle(request.getParameter("title"));
				post.setContent(request.getParameter("content"));
				dao.update(post);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "ERROR"+e.getMessage();
		}
		return "SUCCESS";
	}

	@Override
	public ModelAndView list(ModelAndView mv, int boardId, int page, int listnum) {
		mv.addObject("list", dao.list(new DefaultPage(boardId, page, listnum)));
		mv.setViewName("post/list.basic");
		return mv;
	}

	@Override
	public ModelAndView view(ModelAndView mv, HttpSession session, int boardId, String postId) {
		try {
			CheckLogin(session);
			isManager(session);
			mv.addObject("updateAuthority","T");
		}catch(Exception e){
			mv.addObject("updateAuthority","F");
		}
		Post post = dao.get(boardId, Integer.parseInt(postId));
		dao.updatePostHit(post);	//조회수 증가
		mv.addObject("post", post);
		mv.setViewName("post/view.basic");
		return mv;
	}
	
	public String CheckLogin(HttpSession session) throws Exception{
		Object loginID = session.getAttribute("MYBOARD_MEMBER");
		if ((loginID) == null || (loginID.toString().equals(""))) {
			throw new Exception("ERROR_NOT_LOGIN");
		}
		return (String) loginID;
	}
	
	public String isManager(HttpSession session){
		try {
			session.getAttribute("MYBOARD_MANAGER").toString();
			return "SUCCESS";
		} catch(Exception e) {
			return "ERROR_NOT_MANAGER";
		}
	}

}
