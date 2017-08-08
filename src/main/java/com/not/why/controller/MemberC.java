/*package com.not.why.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class MemberC {
	@Autowired(required = false)
	
	@RequestMapping("admin/member.do")
	public ModelAndView adminMember(ModelAndView mav){
		service.adminMember(mem);
		mav.addObject(
		mav.setViewName(
		return mav;
	}

	// 로그인 접속
	@RequestMapping("login/login.do")
	public String login() {
		return "login/login";
	}

	// 로그인 체크
	@RequestMapping("login/loginCheck.do")
	public ModelAndView loginCheck(User mem, HttpSession session, ModelAndView mav) {
		// 로그인 체크시 null값이 아니면(회원정보가 있으면)
		if (service.loginCheck(mem) != null) {
			// 해당 멤버의 정보를 "mem"이라는 이름으로 세션에 넣겠다.
			session.setAttribute("mem", service.loginCheck(mem));
			session.setAttribute("sessionUser_id", service.loginCheck(mem).getUser_id());
			// 세션 id : 로그인 한 계정의 user_id
			session.setAttribute("id", service.loginCheck(mem).getUser_id());
			// 세션 email : 로그인 한 계정의 email
			session.setAttribute("email", service.loginCheck(mem).getEmail());
			// 세션 name : 로그인 한 계정의 이름
			session.setAttribute("name", service.loginCheck(mem).getUser_name());
			session.setAttribute("newMsg", (Integer)service.newMessageCnt());
			// 보여주는 view 경로 설정( 로그인이 성공 했으면 main으로)
			mav.setViewName("redirect:/main.do");
			// 해당 view에 포함시킬 객체 설정(로그인 여부 msg를 설정함-success)
			mav.addObject("msg", "success");
		} else {
			// 로그인 체크 null값이면 다시 login 페이지로
			mav.setViewName("login/login");
			// 해당 view에 포함시킬 객체 설정
			mav.addObject("msg", "failure");
		}
		return mav;
	}

	// 회원가입폼으로 이동
	@RequestMapping("login/signUp.do")
	public String signUp() {
		return "login/signup";
	}

	//
	@RequestMapping(value = "login/chkDupEmail.do")
	public void checkEmail(HttpServletRequest req, HttpServletResponse res, ModelMap model) throws Exception {
		PrintWriter out = res.getWriter();
		try {
			// 넘어온 ID를 받는다.
			String paramId = (req.getParameter("prmEmail") == null) ? "" : String.valueOf(req.getParameter("prmEmail"));
			User cnt = new User();
			cnt.setEmail(paramId);
			int chkPoint = service.chkDupEmail(cnt);
			out.print(chkPoint);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
		}
	}

	// 실질적인 회원가입 진행로직
	@RequestMapping("login/signUpProc.do")
	public String signUpProc(User ins) {
		service.signUpProc(ins);
		return "redirect:login.do";
	}

	// 로그아웃
	@RequestMapping("login/logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		service.logout(session);
		mav.setViewName("redirect:/main.do");
		mav.addObject("msg", "logout");
		return mav;
	}

	// 회원정보 수정
	@RequestMapping("myPage/update.do")
	public String myPageUserUpdate(User upt, HttpSession session) {
		service.myPageUserUpdate(upt);
		session.setAttribute("mem", service.myPageUserInfo(upt, session));
		return "redirect:/myPage/userInfo.do";
	}

	// 회원 삭제
	@RequestMapping("myPage/delete.do")
	public String myPageUserDelete(User del, HttpSession session) {
		service.myPageUserDelete(del, session);
		return "redirect:/main.do";
	}

}
*/