package com.flab.nsv.system.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flab.nsv.domain.member.Member;

@Mapper
public interface MemberMapper {
	Optional<Member> getById(long id);

	Optional<Member> getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

	Optional<Member> getByUsername(String username);

	long createMember(Member member);

	void updateMember(Member member);
}
