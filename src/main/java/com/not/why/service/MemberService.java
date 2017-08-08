package com.not.why.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.not.why.repository.MemberDAO;
import com.not.why.vo.Member;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDao;

	// 학원에서 했던거 추가

	public Member signUpCheck(Member vo) {
		return memberDao.signUpCheck(vo);
	}

	// 회원가입
	public void signUpProc(Member ins) {
		memberDao.signUpProc(ins);
	}

	public void signOut(HttpSession session) {
		// 세션 변수 개별 삭제
		// session.removeAttribute("userId");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}
}
