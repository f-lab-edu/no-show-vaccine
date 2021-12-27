package com.flab.nsv.system.authentication;

import com.flab.nsv.domain.member.AuthMember;
import com.flab.nsv.common.user.dto.LoginUserRequestDto;

public interface UserLoginService {
	AuthMember login(LoginUserRequestDto loginUserRequestDto);

	void logout();
}
