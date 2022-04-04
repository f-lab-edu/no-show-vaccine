package com.flab.nsv.common.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserRequestDto {
	@NotBlank(message = "아이디는 빈 값일 수 없습니다")
	private String username;

	@NotBlank(message = "비밀번호는 빈 값일 수 없습니다")
	private String password;
}
