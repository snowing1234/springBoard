package com.tstory.joalog.admin.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.tstory.joalog.admin.board.dao.Board;


public interface BoardService {
	public ResponseEntity<?> insert(HttpServletRequest request, HttpSession session, Board dao);
	public Board select(int id);
	public ResponseEntity<?>  delete(HttpServletRequest request, HttpSession session, Map<String, Object> json);
	public ResponseEntity<?> update(HttpServletRequest request, HttpSession session, Board vo);
	
	public List<Board> list(int page, int listnum);
}
