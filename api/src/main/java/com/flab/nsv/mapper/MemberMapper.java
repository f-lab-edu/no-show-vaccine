package com.flab.nsv.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.flab.nsv.domain.member.Member;

@Mapper
public interface MemberMapper {
	Member findByUsername(String username);

	Boolean existsByUsername(String username);

	long insertMember(Member member);

	long deleteMemberByUsername(String username);
}
