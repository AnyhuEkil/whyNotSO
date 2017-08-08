package com.not.why.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.not.why.repository.TestDAO;
import com.not.why.vo.Member;

public class TestService {
	@Autowired(required = false)
	private TestDAO dao;

	public List<Member> testMember(Member mem) {
		return dao.testMember(mem);
	}
}
