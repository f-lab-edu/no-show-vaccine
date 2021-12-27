package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.common.UserRole;
import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.MemberResponseDto;
import com.flab.nsv.system.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper memberMapper;

	public void createMember(Member member) {
		memberMapper.createMember(member);
	}

	public MemberResponseDto getById(long id) {
		return memberMapper.getById(id);
	}

	public void updateMemberTelephone(long userId, String telephone) {
		memberMapper.updateMemberTelephone(userId, telephone);
	}

	public UserRole getRole() {
		return UserRole.MEMBER;
	}
}
