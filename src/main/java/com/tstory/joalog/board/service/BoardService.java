package com.tstory.joalog.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tstory.joalog.board.dao.Board;


public interface BoardService {
	public String insert(HttpServletRequest request, HttpSession session, Board dao);
	public Board select(int id);
	public String delete(HttpServletRequest request, HttpSession session, Map<String, Object> json);
	public String update(HttpServletRequest request, HttpSession session, Board vo);
	
	public List<Board> list(int page, int listnum);
}
