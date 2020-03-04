package com.tstory.joalog.admin.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tstory.joalog.admin.Admin;
import com.tstory.joalog.admin.board.dao.Board;
import com.tstory.joalog.admin.board.dao.BoardDAOImpl;
import com.tstory.joalog.page.DefaultPage;



@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAOImpl dao;

	@Override
	public ResponseEntity<?> insert(HttpServletRequest request, HttpSession session, Board board) {		

		boardValidationCheck(board);
		dao.insert(board);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	
	
	@Override
	public Board select(int id) {
		return dao.get(id);
	}

	
	
	@Override
	public ResponseEntity<?> update (HttpServletRequest request, HttpSession session, Board board) {
		
		boardValidationCheck(board);
		dao.update(board);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<?> delete (HttpServletRequest request, HttpSession session, Map<String, Object> json) {
		
		dao.delete(Integer.parseInt(json.get("id").toString()));
		
		return new ResponseEntity<>("OK", HttpStatus.OK);  
	}



	@Override
	public List<Board> list(int page, int listNum) {
		
		DefaultPage defaultPage = new DefaultPage(page, listNum);
		
		return dao.list(defaultPage);
	}
	
	
	
	/*******************부가적인 메소드**************************/
	
	
	
	private ResponseEntity<?> boardValidationCheck(Board board) {
		
		ResponseEntity<?> rspEntity = null;
		
		//필수 요소
		if (board.getName() == null || board.getName().equals("")) {
			rspEntity = new ResponseEntity("please check boardName", HttpStatus.NO_CONTENT);
		} else {
			//선택요소
			if (board.getFileAttach() == null) 	{	board.setFileAttach("F"); 	}else {board.setFileAttach("T"); };
			if (board.getPrivateSet() == null) 	{	board.setPrivateSet("F"); 	}else {board.setPrivateSet("T"); };
			if (board.getNotice() == null)			{	board.setNotice("F"); 		}else {board.setNotice("T"); };
			if (board.getReply() == null)			{	board.setReply("F"); 		}else {board.setReply("T"); };
			if (board.getComments() == null) 		{	board.setComments("F"); 	}else {board.setComments("T"); };
			if (board.getReplycomment() == null)  	{	board.setReplycomment("F");}else {board.setReplycomment("T"); };
			if (board.getStyle() == null)  		{	board.setStyle("DEFAULT"); 		}
			if (board.getListStyle() == null)  	{	board.setListStyle("DEFAULT"); 	}
			if (board.getEtcOption() == null) 		{	board.setEtcOption("F"); 	}else {board.setEtcOption("T"); };
			if (board.getCategory1() == null)  	{	board.setCategory1("F"); 	}else {board.setCategory1("T"); };
			if (board.getCategory2() == null)  	{	board.setCategory2("F"); 	}else {board.setCategory2("T"); };
		}
		return rspEntity;
	}
}
