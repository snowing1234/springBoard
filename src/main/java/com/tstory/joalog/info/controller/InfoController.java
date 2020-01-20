package com.tstory.joalog.info.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * url Mapping만 하는 Controller임.
 * info 페이지 레벨이 커질 경우 메소드 추가 필요
 */

@Controller
@RequestMapping("/info")
public class InfoController {
	//lct1 = location1
	
	
	@RequestMapping(value="/{lct1}", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mv, HttpSession session,  @PathVariable String lct1) {
		mv.setViewName("info/"+ lct1+".basic");
		return mv;
	}
	
	@RequestMapping(value="/{lct1}/{lct2}", method=RequestMethod.GET)
	public ModelAndView info1(ModelAndView mv, HttpSession session,  @PathVariable String lct1,  @PathVariable String lct2) {
		mv.setViewName("info/"+lct1+"/"+lct2+".basic");
		return mv;
	}
	
	@RequestMapping(value="/{lct1}/{lct2}/{lct3}", method=RequestMethod.GET)
	public ModelAndView info2(ModelAndView mv, HttpSession session,  @PathVariable String lct1,  @PathVariable String lct2, @PathVariable String lct3) {
		mv.setViewName("info/"+lct1+"/"+lct2+"/"+lct3+".basic");
		return mv;
	}
}
