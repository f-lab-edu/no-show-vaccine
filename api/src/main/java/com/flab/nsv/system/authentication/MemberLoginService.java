package com.flab.nsv.system.authentication;

import com.flab.nsv.domain.member.AuthMember;
import com.flab.nsv.member.dto.LoginMemberRequestDto;

public interface MemberLoginService {
	AuthMember login(LoginMemberRequestDto loginMemberRequestDto);

	void logout();
}
