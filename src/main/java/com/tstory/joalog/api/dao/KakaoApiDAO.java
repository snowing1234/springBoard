package com.tstory.joalog.api.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface KakaoApiDAO {

	public void insertUserData(KakaoUser user);
	public KakaoUser getUser(String id);
	public void updateUser(KakaoUser user);
}
