package com.tstory.joalog.api;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cedarsoftware.util.io.JsonReader;
import com.tstory.joalog.api.dao.KakaoApiDAO;
import com.tstory.joalog.api.dao.KakaoUser;
import com.tstory.joalog.api.service.ApiService;

public class ParsingTest {

	@Autowired
	KakaoApiDAO dao;
	
	@Test
	public void test(){
		
		
		ApiService service = new ApiService();
		String jsonData = "{\"id\":1259114324,\"connected_at\":\"2020-01-14T16:07:25Z\",\"properties\":{\"nickname\":\"🤗\",\"profile_image\":\"http://k.kakaocdn.net/dn/GU36i/btqAEVQ5ATo/6lAvkZmZ7RjN30guMUcLRK/img_640x640.jpg\",\"thumbnail_image\":\"http://k.kakaocdn.net/dn/GU36i/btqAEVQ5ATo/6lAvkZmZ7RjN30guMUcLRK/img_110x110.jpg\"},\"kakao_account\":{\"profile_needs_agreement\":false,\"profile\":{\"nickname\":\"🤗\",\"thumbnail_image_url\":\"http://k.kakaocdn.net/dn/qfGxZ/btqBcxQHGlV/KWE7f4DSylfAn5SsOVUjM1/img_110x110.jpg\",\"profile_image_url\":\"http://k.kakaocdn.net/dn/qfGxZ/btqBcxQHGlV/KWE7f4DSylfAn5SsOVUjM1/img_640x640.jpg\"},\"has_email\":true,\"email_needs_agreement\":false,\"is_email_valid\":true,\"is_email_verified\":true,\"email\":\"jisue1022@naver.com\"}}";
		Map<String, Object> map = JsonReader.jsonToMaps(jsonData);
		Map<String, Object> profile = (Map<String, Object>)((Map<String, Object>) map.get("kakao_account")).get("profile");
		
		KakaoUser user = new KakaoUser();
		user.setId(map.get("id").toString());
		user.setAccessToken("accessTokenssowifdjofijowidf49w5d4f5d545#"); //accessToken
		user.setNick(profile.get("nickname").toString());
		user.setThumbnail(profile.get("thumbnail_image_url").toString());
		dao.insertUserData(user);
		
	}
}
