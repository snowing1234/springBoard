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
		int postId = -1;
		try {
			vo.setWriter(CheckLogin(session));
			vo.setIp(MemberUtil.getIp(request));
			postId=dao.insert(vo);
		} catch (Exception e) {
			return e.getMessage();
		}
		return new Integer(postId).toString();
	}

	@Override
	public Post select(String id) {
		
		return null;
	}

	@Override
	public String delete(HttpSession session, int boardId, int postId) {
		try {
			String loginId = CheckLogin(session);
			Post post = dao.get(boardId, postId);
			if ( ! loginId.equals(post.getWriter())) {
				throw new Exception("NOT_HAVE_PRIVILIAGE");
			}
			dao.delete(boardId, postId);
		} catch (Exception e) {
			return e.getMessage();
		}
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
			String writer = CheckLogin(session);
			boolean updateAuth = false;
			
			if (writer.equals(post.getWriter()) ) {
				updateAuth = true;
			} else if ( isManager(session).equals("SUCCESS")) {
				updateAuth = true;
			}
			
			if (updateAuth) {
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
	
	public void updateFileCount(int boardId, int postId){
		Post post = new Post();
		post.setBoardId(boardId);
		post.setPostId(postId);
	    dao.updateFileCount(post);
	}

	@Override
	public ModelAndView list(ModelAndView mv, int boardId, int page, int listnum) {
		mv.addObject("list", dao.list(new DefaultPage(boardId, page, listnum)));
		mv.setViewName("post/list.basic");
		return mv;
	}

	@Override
	public ModelAndView view(ModelAndView mv, HttpSession session, int boardId, int postId) {
		Post post = null;
		
		post = dao.get(boardId, postId);
		dao.updatePostHit(post);	//조회수 증가
		mv.addObject("post", post);
		mv.addObject("updateAuthority","F");	
		mv.setViewName("post/view.basic");
		//삭제 및 수정 권한 체크
		try {
			String loginId = CheckLogin(session);  
			

			if (loginId.equals(post.getWriter())) {
				mv.addObject("updateAuthority","T");
			}else if (isManager(session).equals("SUCCESS")){
				mv.addObject("updateAuthority","T");
			}
		}catch(Exception e){}
		return mv;
	}
	
	public String CheckLogin(HttpSession session) throws Exception{
		Object loginID = session.getAttribute("MYBOARD_MEMBER");
		if ((loginID) == null || (loginID.toString().equals(""))) {
			throw new Exception("ERROR_NOT_LOGIN");
		}
		return ((String)loginID).split("KAKAO")[0];
	}
	
	public String isManager(HttpSession session){
		try {
			session.getAttribute("MYBOARD_MANAGER").toString();
			return "SUCCESS";
		} catch(Exception e) {
			return "ERROR_NOT_MANAGER";
		}
	}

	public void fileDelete(int boardId, int postId) {
		Post post=  new Post();
		post.setBoardId(boardId);
		post.setPostId(postId);
		dao.decreaseFileCnt(post);
	}

}
