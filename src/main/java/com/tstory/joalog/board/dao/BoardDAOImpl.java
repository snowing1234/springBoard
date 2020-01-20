package com.tstory.joalog.board.dao;

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
		try {
		sqlSession.selectOne("board.getBoardInfo", id);
		} catch(Exception e) {
			e.printStackTrace();
		}
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
	
	public void isDupleID(String id) throws Exception {
		Board board = sqlSession.selectOne("board.getBoardInfo", id);
		if (board != null) {
			throw new Exception("ERROR_DUBPLE_ID");
		}
	}
	
	public void idCheck(Object id) throws Exception {
		if (id==null) {
			throw new Exception("ERROR_NULL_ID");
		}else{
			Board board = sqlSession.selectOne("board.getBoardInfo", id.toString());
			if (board == null) {
				throw new Exception("ERROR_NON_EXIST_BOARD_ID");
			}
		}
	}
	
	//부가적인 펑션 ------------------------------------------------------------
	public Board SetNullToDefault(Board vo) throws Exception{
		//필수 요소
		if (vo.getName() == null || vo.getName().equals("")) throw new Exception("ERROR_NULL_NAME");
		//선택요소
		if (vo.getFileAttach() == null) 	{	vo.setFileAttach("F"); 	}else {vo.setFileAttach("T"); };
		if (vo.getPrivateSet() == null) 	{	vo.setPrivateSet("F"); 	}else {vo.setPrivateSet("T"); };
		if (vo.getNotice() == null)			{	vo.setNotice("F"); 		}else {vo.setNotice("T"); };
		if (vo.getReply() == null)			{	vo.setReply("F"); 		}else {vo.setReply("T"); };
		if (vo.getComments() == null) 		{	vo.setComments("F"); 	}else {vo.setComments("T"); };
		if (vo.getReplycomment() == null)  	{	vo.setReplycomment("F");}else {vo.setReplycomment("T"); };
		if (vo.getStyle() == null)  		{	vo.setStyle("DEFAULT"); 		}
		if (vo.getListStyle() == null)  	{	vo.setListStyle("DEFAULT"); 	}
		if (vo.getEtcOption() == null) 		{	vo.setEtcOption("F"); 	}else {vo.setEtcOption("T"); };
		if (vo.getCategory1() == null)  	{	vo.setCategory1("F"); 	}else {vo.setCategory1("T"); };
		if (vo.getCategory2() == null)  	{	vo.setCategory2("F"); 	}else {vo.setCategory2("T"); };
		return vo;
	}
	
	
}
