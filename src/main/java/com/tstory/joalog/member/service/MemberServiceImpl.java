package com.tstory.joalog.member.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.member.dao.Member;
import com.tstory.joalog.member.dao.MemberDAOImpl;
import com.tstory.joalog.member.dao.MemberUtil;
import com.tstory.joalog.post.dao.Post;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAOImpl dao;
	
	@Override
	public String insert(HttpServletRequest request) {
		try {
			Member mem = new Member();
			mem.setId(request.getParameter("id"));
			mem.setPw(request.getParameter("pw"));
			mem.setNickName(request.getParameter("nickName"));
			String pw2 = request.getParameter("pw2");
			
			//값 체크
			idDupleCheck(mem.getId());
			nickNameDupleCheck(mem.getNickName());
			if (! mem.getPw().equals(pw2)) {
				return "ERROR_NON_EQ_PW";
			}
			
			//회원가입
			dao.insert(mem);
			return "SUCCESS";
		} catch(Exception e) {}
		return "ERROR";
	}

	@Override
	public boolean login(Member vo, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Member mem = dao.get(vo.getId());
			
			//로그인 처리
			if ( mem != null && mem.getPw().equals(vo.getPw()) ){
				//관리자 확인
				try {
					dao.isManager(mem.getId());
					session.setAttribute("MYBOARD_MANAGER", mem.getId());
				} catch(Exception e){
					e.printStackTrace();
				}
				session.setAttribute("MYBOARD_MEMBER", mem.getId());
				session.setAttribute("MYBOARD_NICK", mem.getNickName());
				return true;
			}
		}catch (Exception e) {}
		return false;
	}
	
	@Override
	public void logout(HttpServletRequest request) {
		MemberUtil.setLogout(request.getSession());
	}
	
	@Override
	public ModelAndView getMyInfo(ModelAndView mv, HttpSession session) {
		Member mem = null;
		try {
			mem = dao.get(session.getAttribute("MYBOARD_MEMBER").toString());
			mv.setViewName("member/myInfo.basic");
			mv.addObject("member", mem);
		} catch (Exception e) {
			mem = null;
			mv.setViewName("info/main.basic");
		}
		return mv;
	}
	
	
	@Override
	public Member select(String id) {
		return null;
	}

	@Override
	public String delete(ModelAndView mv, HttpSession session,  @RequestBody Map<String, Object> params)  {
		try {
			String id = MemberUtil.getLoginId(session);
			dao.delete(id);
			dao.get(id);
		} catch(Exception e) {
			if (e.getMessage().equals("ERROR_NOT_EXIST_MEMBER")){
				MemberUtil.setLogout(session);
				return "SUCCESS";
			}
		}
		return "ERROR";
	}

	@Override
	public String updatePW(HttpSession session, Map<String, Object> params){
		try {
			String id = MemberUtil.getLoginId(session);
			Member mem = dao.get(id);
			//비밀번호 체크
			if (mem.getPw().equals(params.get("currentPW"))){
				mem.setPw(params.get("changePW").toString());
				//비밀번호 변경
				dao.updatePW(mem);
				return "SUCCESS";
			}
		} catch(Exception e){
			return e.getMessage();
		}
		return "ERROR";
	}

	@Override
	public List<Post> list(int page, int listnum) {
		return null;
	}

	/*
	 * getId를 했을 때, Exception이 발생하면 검색하는 id가 없다는 것이므로, SUCCESS
	 */
	@Override
	public String idDupleCheck(String id) {
		try {
			dao.get(id);
		}catch(Exception e){
			return "SUCCESS";
		}
		return "ERROR";
	}

	/*
	 * getNickName를 했을 때, Exception이 발생하면 검색하는 nickName이 없다는 것이므로, SUCCESS
	 */
	@Override
	public String nickNameDupleCheck(String nickName) {
		try {
			dao.nickNameDupleCheck(nickName);
		}catch(Exception e){
			return "SUCCESS";
		}
		return "ERROR";
	}
	
	public boolean isManager(String id){
		try {
			dao.isManager(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean isManager(Member mem){
		try {
			dao.isManager(mem.getId());
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	

}
