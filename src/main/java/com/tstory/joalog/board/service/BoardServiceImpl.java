package com.tstory.joalog.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tstory.joalog.board.dao.Board;
import com.tstory.joalog.board.dao.BoardDAOImpl;
import com.tstory.joalog.page.DefaultPage;

/*
 * 
 * 필수체크
 * 1. 로그인이 되어 있는지
 * 2. 로그인 된 사용자가 관리자인지
 */

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAOImpl dao;

	@Override
	public String insert(HttpServletRequest request, HttpSession session, Board vo) {
		try {
			CheckLogin(session);	//ERROR_NOT_LOGIN
			isManager(session);						//ERROR_NOT_MANAGER
			vo = dao.SetNullToDefault(vo);			//ERROR_NULL_ID, ERROR_NULL_NAME
			dao.insert(vo);	
			return "SUCCESS";//나머지 오류
		} catch (Exception e){
			return e.getMessage();
		}
	}

	@Override
	public Board select(int id) {
		return dao.get(id);
	}

	@Override
	public String delete (HttpServletRequest request, HttpSession session, Map<String, Object> json) {
		// TODO Auto-generated method stub
		try {
			CheckLogin(session);	//ERROR_NOT_LOGIN
			System.out.println(1);
			isManager(session);					//ERROR_NOT_MANAGER
			System.out.println(json.get("id").getClass());
			dao.delete(Integer.parseInt(json.get("id").toString()));	//나머지 오류
			System.out.println(3);
		} catch(Exception e) {
			return e.getMessage();
		}
		return "SUCCESS";
	}

	@Override
	public String update (HttpServletRequest request, HttpSession session, Board vo) {
		// TODO Auto-generated method stub
		try {
			CheckLogin(session);	//ERROR_NOT_LOGIN
			isManager(session);					//ERROR_NOT_MANAGER
			vo = dao.SetNullToDefault(vo);			//ERROR_NULL_ID, ERROR_NULL_NAME
			dao.update(vo);							//나머지 오류
		} catch(Exception e) {
			return e.getMessage();
		}
		return "SUCCESS";
	}

	@Override
	public List<Board> list(int page, int listNum) {
		DefaultPage defaultPage = new DefaultPage(page, listNum);
		return dao.list(defaultPage);
	}
	
	public String CheckLogin(HttpSession session) throws Exception{
		Object loginID = session.getAttribute("MYBOARD_MEMBER");
		if (loginID == null) {
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
