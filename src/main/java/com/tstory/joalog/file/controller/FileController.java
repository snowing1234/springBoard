package com.tstory.joalog.file.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.tstory.joalog.file.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Inject
	FileService service;
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String fileupload() {
		return "post/test_file.basic";
	}
	
	/*
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView uploadForm(ModelAndView mv, HttpSession session, HttpRequest request,  MultipartFile file, File fileInfo) {
		try {
			//service.checkLogin(session);
			//service.upload(mv, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	*/

}
