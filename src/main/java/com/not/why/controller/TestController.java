package com.not.why.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.not.why.service.TestService;
import com.not.why.vo.Member;

@Controller
@RequestMapping("/*")
public class TestController {
	@Autowired(required = false)
	TestService service;
	
	@RequestMapping("test.do")
	public ModelAndView testMember(Member mem, ModelAndView mav){
		mav.addObject("testMem", service.testMember(mem));
		mav.setViewName("testM");
		return mav;
	}
}
