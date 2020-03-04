package com.tstory.joalog.admin.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tstory.joalog.page.DefaultPage;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public void insert(Board vo) {
		sqlSession.insert("board.insert", vo);		
	}

	@Override
	public Board get(int id) {
		return sqlSession.selectOne("board.getBoardInfo", id);
	}

	@Override
	public void update(Board vo) {
		sqlSession.update("board.update", vo);
	}

	@Override
	public void delete(int id) {
		sqlSession.delete("board.delete", id);
	}

	@Override
	public List<Board> list(DefaultPage page) {
		return sqlSession.selectList("board.getList", page);
	}

}
