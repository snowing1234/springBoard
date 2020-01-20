package com.tstory.joalog.board.dao;

import java.util.List;

import com.tstory.joalog.page.DefaultPage;

public interface BoardDAO {
	
	public void insert(Board dao) throws Exception;
	public Board get(int boardId);
	public void update(Board dao) throws Exception;
	public void delete(int id) throws Exception;
	public List<Board> list(DefaultPage page) ;
	
}
