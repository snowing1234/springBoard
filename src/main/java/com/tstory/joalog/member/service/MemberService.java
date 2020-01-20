package com.tstory.joalog.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.member.dao.Member;
import com.tstory.joalog.post.dao.Post;


public interface MemberService {
	public String insert(HttpServletRequest request);
	public boolean login(Member dao, HttpServletRequest request);
	public void logout(HttpServletRequest request);
	public ModelAndView getMyInfo(ModelAndView mv, HttpSession session);
	public Member select(String id);
	public String delete(ModelAndView mv, HttpSession session,  @RequestBody Map<String, Object> params);
	public String updatePW(HttpSession session, Map<String, Object> params);
	
	public String idDupleCheck(String id);
	public String nickNameDupleCheck(String id);
	
	public List<Post> list(int page, int listnum);
}
