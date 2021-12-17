package com.flab.nsv.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.flab.nsv.domain.member.Member;

@Mapper
public interface MemberMapper {
	Optional<Member> getByUsername(String username);

	Optional<Member> getById(long id);

	long createMember(Member member);

	void updateMember(Member member);

	long deleteMemberByUsername(String username);
}
