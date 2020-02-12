package com.tstory.joalog.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.URLEncoder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.cedarsoftware.util.io.JsonReader;
import com.tstory.joalog.api.dao.KakaoApiDAO;
import com.tstory.joalog.api.dao.KakaoUser;

@Service("ApiService")
public class ApiService {

	@Inject
	public KakaoApiDAO dao;
	
	private final String KAKAO_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
	private final String KAKAO_TOKEN_VALIDITY_CHECK = "https://kapi.kakao.com/v2/user/me";
	private final String TISTORY_TOKEN_URL = "https://www.tistory.com/oauth/access_token?";
	private final String TISTORY_POST_LIST_URL = "https://www.tistory.com/oauth/access_token";
	
	
	public String userAgree(HttpServletRequest request, HttpSession session){
		//토큰 획득
		String host = request.getParameter("state"); //도메인 주소가 바뀔 것을 대비...!
		if ( request.getParameter("code") == null ) {
			return "member/login.basic"; 
		}
			
		//토근 사용 및 인증
		Map<String, Object> authData = authKakao(request.getParameter("code"), host);
		if (authData != null && authData.get("access_token") == null) {
			return "member/login.basic";
		}
		session.setAttribute("kakao_access_token", authData.get("access_token"));
		
		//토큰 재인등 및 사용자 정보 획득
		Map<String, Object> tokenResult = tokenValidityCheck(authData.get("access_token").toString());
		if (tokenResult != null && tokenResult.get("id") != null) {
			session.setAttribute("kakao_id", authData.get("access_token"));
		}
		
		//카카오 사용자 객체 생성
		Map<String, Object> profile = (Map<String, Object>)((Map<String, Object>) tokenResult.get("kakao_account")).get("profile");
		KakaoUser user = new KakaoUser();
		user.setId(tokenResult.get("id").toString());
		user.setAccessToken(authData.get("access_token").toString()); //accessToken
		user.setNick(profile.get("nickname").toString());
		if (profile.get("thumbnail_image_url") != null) {
			user.setThumbnail(profile.get("thumbnail_image_url").toString());
		}
		
		if ( dao.getUser(tokenResult.get("id").toString()) != null ) {
			dao.updateUser(user);
		}else {
			dao.insertUserData(user);
		}
		session.setAttribute("MYBOARD_MEMBER", "KAKAO"+user.getId());
		session.setAttribute("MYBOARD_NICK", user.getNick());
		return "info/main.basic";
	}
	
	
	//로그인
	public Map<String, Object> authKakao(String code, String host) {

		//POST방식 연결 설정
		HttpPost httpPost = new HttpPost(KAKAO_TOKEN_URL);
		httpPost.addHeader("Content-type", " application/x-www-form-urlencoded;charset=utf-8");
		
		String data = "grant_type=authorization_code&"
				+ "client_id=965dbed2b5cdf6d4b6ad511f46129932&"
				+ "redirect_uri=http://"+host+"/springBoard/api/kakao.do&"
				+ "code="+code;
		
		try {
			//실행 및 응답
			httpPost.setEntity(new StringEntity(data));
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			
			//응답데이터 받아오기
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			httpClient.close();
			
			return JsonReader.jsonToMaps(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//사용자 토큰 유효성 검사 및 정보 얻기 (아이디 받아오기 & 토큰 유효성 검사)
	public Map<String, Object> tokenValidityCheck(String access_token) {

		//POST방식 연결 설정
		HttpGet httpGet = new HttpGet(KAKAO_TOKEN_VALIDITY_CHECK);
		httpGet.addHeader("Authorization", "Bearer "+access_token);
		httpGet.addHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		try {
			//실행 및 응답
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			System.out.println("\u001B[46m"+ " excuted httpClient " +"\u001B[0m");
			//응답데이터 받아오기
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			httpClient.close();
			
			return JsonReader.jsonToMaps(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*
	public String userAgreeTistory(HttpServletRequest request, HttpSession session) {
		//토큰 획득
		String host = request.getParameter("state"); //도메인 주소가 바뀔 것을 대비...!
		if ( request.getParameter("code") == null ) {	//코드값이 없으면 에러 발생한 것.
			return "member/login.basic"; 
		}
		//토근 사용 및 인증
		String authData = authTistory(request.getParameter("code"), host);
		if (authData.startsWith("error")) {
			return authData;
		}
		
		/*
		//토큰 재인등 및 사용자 정보 획득
		Map<String, Object> tokenResult = getListTistory(authData);
		if (tokenResult != null && tokenResult.get("code") != null) {
			session.setAttribute("tistory_auth_code", authData);
		}
		System.out.println("5" +  authData.toString());
*//*
		return "SUCCESS";
	}
	
	//로그인
	private  String authTistory(String code, String host) {

		//POST방식 연결 설정
		String data = "client_id=75b39948020ccbb447a6246fe5de10be&"
				+ "client_secret=75b39948020ccbb447a6246fe5de10bea60ff17ad682c636acb920947159a8181f3da5ab&"
				+ "redirect_uri=http://"+host+"/springBoard/api/tistory/list.do&"
				+ "code="+code+"&"
				+ "grant_type=authorization_code";
		
		HttpGet httpGet = new HttpGet(TISTORY_TOKEN_URL+data);
		httpGet.addHeader("Content-type", "text/plain;charset=utf-8");
		
		try {
			//실행 및 응답
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			
			//응답데이터 받아오기
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			httpClient.close();
			System.out.println(response.toString());
			return response.toString(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}		
	
	public Map<String, Object> getListTistory(String access_token) {

		//POST방식 연결 설정
		HttpGet httpGet = new HttpGet(TISTORY_POST_LIST_URL);
		httpGet.addHeader("Authorization", "Bearer "+access_token);
		httpGet.addHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		try {
			//실행 및 응답
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			System.out.println("\u001B[46m"+ " excuted httpClient " +"\u001B[0m");
			//응답데이터 받아오기
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			httpClient.close();
			
			return JsonReader.jsonToMaps(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
}
