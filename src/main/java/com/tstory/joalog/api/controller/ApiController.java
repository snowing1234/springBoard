package com.tstory.joalog.api.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.api.service.ApiService;

@Controller
@RequestMapping("/auth")
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
}
