package com.not.why.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.not.why.vo.Member;

@Repository
public interface TestDAO {

	public List<Member> testMember(Member mem);
}
