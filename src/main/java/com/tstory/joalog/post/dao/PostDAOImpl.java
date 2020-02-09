package com.tstory.joalog.post.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tstory.joalog.page.DefaultPage;

@Repository("PostDAO")
public class PostDAOImpl implements PostDAO{
	
	@Inject
	private SqlSessionTemplate sqlSession;	

	@Override
	public int insert(Post vo) {
		sqlSession.insert("post.insert", vo);
		return vo.getPostId();
	}
	@Override
	public Post get(int boardId, int postId) {
		return sqlSession.selectOne("post.select", new Post(boardId, postId));
	}
	@Override
	public void update(Post vo) {
		sqlSession.update("post.update", vo);
	}
	@Override
	public boolean delete(int boardId, int postId) {
		sqlSession.delete("post.delete", new Post(boardId, postId));
		return false;
	}
	@Override
	public List<Post> list(DefaultPage defaultPage) {
		return sqlSession.selectList("post.getList", defaultPage);
	}
	
	public void updatePostHit(Post post) {
		sqlSession.update("post.updatePostHit", post);
	}
	
	public void updateFileCount(Post post) {
		sqlSession.update("post.updateFileCount", post);
	}
	public void decreaseFileCnt(Post post) {
		sqlSession.update("post.decreasPostFileCount", post);
	}
}
