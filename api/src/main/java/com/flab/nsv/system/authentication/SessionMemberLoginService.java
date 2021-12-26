package com.flab.nsv.system.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.member.AuthMember;
import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.LoginMemberRequestDto;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SessionMemberLoginService implements MemberLoginService{
	private final HttpSession session;
	private final MemberMapper memberMapper;
	private final EncryptService encryptService;

	@Override
	public AuthMember login(LoginMemberRequestDto loginMemberRequestDto) {
		String encryptedPassword = encryptService.encrypt(loginMemberRequestDto.getPassword());

		Member foundMember = memberMapper.getByUsernameAndPassword(loginMemberRequestDto.getUsername(), encryptedPassword)
			.orElseThrow(NotFoundMemberException::new);
		AuthMember authMember = new AuthMember(foundMember);
		session.setAttribute("LOGINID", authMember.getUsername());

		return authMember;
	}

	@Override
	public void logout() {
		session.removeAttribute("LOGINID");
	}
}
