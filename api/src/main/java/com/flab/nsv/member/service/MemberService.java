package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.CreateMemberRequestDto;
import com.flab.nsv.member.dto.UpdateMemberRequestDto;
import com.flab.nsv.member.exception.DuplicatedUsernameException;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.authentication.EncryptService;
import com.flab.nsv.system.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper memberMapper;
	private final EncryptService encryptService;

	public void joinMember(CreateMemberRequestDto createMemberRequestDto) {
		memberMapper.getByUsername(createMemberRequestDto.getUsername()).ifPresent(member -> {
			throw new DuplicatedUsernameException();
		});
		String encryptedPassword = encryptService.encrypt(createMemberRequestDto.getPassword());
		Member member = createMemberRequestDto.toEntity(encryptedPassword);
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
		updateMemberRequestDto.getUpdatePassword().ifPresent(updatePassword -> {
			String encryptedPassword = encryptService.encrypt(updatePassword);
			member.changePassword(encryptedPassword);
		});
		updateMemberRequestDto.getUpdateTelephone().ifPresent(member::changeTelephone);
		memberMapper.updateMember(member);
	}
}
