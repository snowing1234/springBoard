package com.tstory.joalog.member.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tstory.joalog.member.dao.Member;
import com.tstory.joalog.member.service.MemberServiceImpl;


@Controller
public class MemberController {
	
	@Inject
	private MemberServiceImpl memberService;	
	
	/*********************************** link *********************************************/
	
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String insert(Model model){
		return "member/insert.basic";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login(Model model){
		return "member/login.basic";
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public String update(Model model){
		return "member/update.basic";
	}
	
	@RequestMapping(value="/member/pwCheck", method=RequestMethod.GET)
	public String pwCheck(HttpServletRequest request){
		return "member/pwCheck.basic";
	}
	
	@RequestMapping(value="/member/myInfo", method=RequestMethod.GET)
	public ModelAndView get(ModelAndView mv, HttpSession session){
		return memberService.getMyInfo(mv, session);
	}
	
	/*********************************** process *********************************************/
	//회원가입
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public @ResponseBody String insertPrss(HttpServletRequest request){
		return memberService.insert(request);
	}
	
	//회원가입 - 아이디 중복체크 / nickNameDupleCheck
	@RequestMapping(value="/member/idDupleCheck", method=RequestMethod.GET) //deletePrss
	public @ResponseBody String idDupleCheck(String id) {
		return memberService.idDupleCheck(id);
	}
	
	//회원가입 - 닉네임 중복체크 
	@RequestMapping(value="/member/nickNameDupleCheck", method=RequestMethod.GET) //deletePrss
	public @ResponseBody String nickNameDupleCheck(String nickName) {
		return memberService.nickNameDupleCheck(nickName);
	}
	
	//로그인
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public @ResponseBody boolean loginPrss(HttpServletRequest request, Member member){
		return memberService.login(member, request);
	}
	
	//로그아웃
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logoutPrss(ModelAndView mv, HttpServletRequest request){
		memberService.logout(request);
		return "info/main.basic";
	}
	
	//회원정보 수정
	@RequestMapping(value="/member/updatePW", method=RequestMethod.POST) //updatePrss
	public @ResponseBody String updatePWPrss(HttpSession session, @RequestBody Map<String, Object> params){
		return memberService.updatePW(session, params);
	}
	
	//회원 탈퇴
	@RequestMapping(value="/member/delete", method=RequestMethod.POST) //deletePrss
	public @ResponseBody String deletePrss(ModelAndView mv, HttpSession session,  @RequestBody Map<String, Object> params) {
		return memberService.delete(mv, session, params);
	}
}
