package com.tstory.joalog.api.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cedarsoftware.util.io.JsonReader;
import com.tstory.joalog.api.service.ApiService;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Inject
	private ApiService service;
	
	@RequestMapping(value="", method=RequestMethod.GET) 
	public ModelAndView test(ModelAndView mv, HttpSession session) {
		mv.setViewName("info/main.basic");
		return mv;
	}
	
	@RequestMapping(value="/kakao", method=RequestMethod.GET) 
	public String authKakao(HttpServletRequest request, HttpSession session) {
		return service.userAgree(request, session);
	}
	
	@RequestMapping(value="/kakao_auth", method=RequestMethod.GET) 
	public @ResponseBody String authKakaoO(HttpServletRequest request, HttpSession session) {
		try {
			request.getParameter("code");
			request.getParameter("error");
		}
		catch (Error e){
			return "error";
		}
		return "";
	}
	
	/*
	@RequestMapping(value="/tistory/list", method=RequestMethod.GET) 
	public @ResponseBody String testtest(HttpServletRequest request, HttpSession session) {
		System.out.println("*************gettin");
		return service.userAgreeTistory(request, session);
	}
	*/
}
