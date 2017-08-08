package com.not.why.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.not.why.service.MemberService;
import com.not.why.vo.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired(required = false)
	private MemberService service;

	/*
	 * @RequestMapping("admim.do") public ModelAndView adminMember(ModelAndView
	 * mav){ service.adminMember(mem); mav.addObject( mav.setViewName( return
	 * mav; }
	 */

	// 로그인 페이지
	@RequestMapping("signUp.do")
	public String signUp() {
		return "member/signUp";
	}

	// 로그인 체크
	@RequestMapping("signUpCheck.do")
	public ModelAndView signUpCheck(Member mem, HttpSession session, ModelAndView mav) {
		// 로그인 체크시 null값이 아니면(회원정보가 있으면)
		if (service.signUpCheck(mem) != null) {
			// 해당 멤버의 정보를 "mem"이라는 이름으로 세션에 넣겠다.
			session.setAttribute("mem", service.signUpCheck(mem));
			session.setAttribute("sessionUser_id", service.signUpCheck(mem).getUser_id());
			// 보여주는 view 경로 설정( 로그인이 성공 했으면 main으로)
			mav.setViewName("redirect:/main.do");
			// 해당 view에 포함시킬 객체 설정(로그인 여부 msg를 설정함-success)
			mav.addObject("msg", "success");
		} else {
			// 로그인 체크 null값이면 다시 login 페이지로
			mav.setViewName("member/signUp");
			// 해당 view에 포함시킬 객체 설정
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	// 회원가입 페이지
	@RequestMapping("signIn.do")
	public String signIn() {
		return "member/signIn";
	}

	// 회원가입 진행
	@RequestMapping("signUpProc.do")
	public String signUpProc(Member ins) {
		service.signUpProc(ins);
		return "redirect:signUp.do";
	}

	// 로그아웃
	@RequestMapping("signOut.do")
	public ModelAndView signOut(HttpSession session, ModelAndView mav) {
		service.signOut(session);
		mav.setViewName("redirect:/main.do");
		mav.addObject("msg", "signOut");
		return mav;
	}

}
