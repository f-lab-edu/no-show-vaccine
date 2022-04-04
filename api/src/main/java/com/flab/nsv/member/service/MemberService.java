package com.flab.nsv.member.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.flab.nsv.enums.UserRole;
import com.flab.nsv.domain.member.Member;
import com.flab.nsv.domain.member.MemberRepository;
import com.flab.nsv.member.exception.DuplicatedUsernameException;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.authentication.EncryptService;
import com.flab.nsv.system.mapper.MemberMapper;
import com.flab.nsv.system.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper memberMapper;
	private final UserMapper userMapper;
	private final MemberRepository memberRepository;
	private final EncryptService encryptService;

	@Transactional
	public void createMember(Member member) {
		userMapper.getByUsername(member.getUsername()).ifPresent(u -> {
			throw new DuplicatedUsernameException();
		});
		memberRepository.save(member);
	}



	@Transactional
	public void updateMemberTelephone(long userId, String telephone) {
		memberMapper.updateMemberTelephone(userId, telephone);
	}

	public UserRole getRole() {
		return UserRole.MEMBER;
	}
}
