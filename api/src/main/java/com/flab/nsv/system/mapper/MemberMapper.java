package com.flab.nsv.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.MemberResponseDto;

@Mapper
public interface MemberMapper {
	MemberResponseDto getById(long userId);

	void createMember(Member member);

	void updateMemberTelephone(@Param("userId")Long userId, @Param("telephone")String telephone);
}
