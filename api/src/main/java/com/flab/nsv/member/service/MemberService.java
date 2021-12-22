package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.CreateMemberRequestDto;
import com.flab.nsv.mapper.MemberMapper;
import com.flab.nsv.member.dto.UpdateMemberRequestDto;
import com.flab.nsv.member.exception.DuplicatedUsernameException;
import com.flab.nsv.member.exception.NotFoundMemberException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper memberMapper;

	public void joinMember(CreateMemberRequestDto createMemberRequestDto) {
		memberMapper.getByUsername(createMemberRequestDto.getUsername()).ifPresent(member -> {
			throw new DuplicatedUsernameException();
		});
		Member member = createMemberRequestDto.toEntity();
		memberMapper.createMember(member);
	}

	public Member getById(long id) {
		return memberMapper.getById(id).orElseThrow(NotFoundMemberException::new);
	}

	public Member getByUsername(String username) {
		return memberMapper.getByUsername(username).orElseThrow(NotFoundMemberException::new);
	}

	public void updateMember(long id, UpdateMemberRequestDto updateMemberRequestDto) {
		Member member = memberMapper.getById(id).orElseThrow(NotFoundMemberException::new);

		updateMemberRequestDto.getUpdatePassword().ifPresent(member::changePassword);
		updateMemberRequestDto.getUpdateTelephone().ifPresent(member::changeTelephone);
		memberMapper.updateMember(member);
	}
}
