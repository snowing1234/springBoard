package com.tstory.joalog.post.dao;

import java.util.List;

import com.tstory.joalog.page.DefaultPage;

public interface PostDAO {
	public boolean insert(Post dao);
	public Post get(int boardId, int postId);
	public void update(Post dao);
	public boolean delete(int boardId, int postId);
	public List<Post> list(DefaultPage defaultPage);
	public void updatePostHit(Post post);
	
}
