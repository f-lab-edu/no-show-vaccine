package com.flab.nsv.system.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.member.AuthMember;
import com.flab.nsv.common.user.dto.LoginUserRequestDto;
import com.flab.nsv.member.dto.MemberResponseDto;
import com.flab.nsv.common.user.dto.UserResponseDto;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.mapper.UserMapper;
import com.flab.nsv.system.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SessionUserLoginService implements UserLoginService {
	private final HttpSession session;
	private final UserMapper userMapper;
	private final MemberMapper memberMapper;
	private final EncryptService encryptService;

	@Override
	public AuthMember login(LoginUserRequestDto loginUserRequestDto) {
		String encryptedPassword = encryptService.encrypt(loginUserRequestDto.getPassword());
		UserResponseDto foundUser = userMapper.getByUsernameAndPassword(loginUserRequestDto.getUsername(), encryptedPassword)
			.orElseThrow(NotFoundMemberException::new);

		MemberResponseDto memberInfo = memberMapper.getById(foundUser.getId());
		AuthMember authMember = new AuthMember(foundUser.getId(), foundUser.getUsername()
			, memberInfo.getNoShow(), memberInfo.getNoShow());
		session.setAttribute("LOGINID", foundUser.getUsername());

		return authMember;
	}

	@Override
	public void logout() {
		session.removeAttribute("LOGINID");
	}
}
