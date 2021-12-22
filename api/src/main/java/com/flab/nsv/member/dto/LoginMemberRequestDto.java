package com.flab.nsv.member.dto;

import javax.validation.constraints.NotBlank;

import com.flab.nsv.domain.member.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginMemberRequestDto {
	@NotBlank(message = "아이디는 빈 값일 수 없습니다")
	private String username;

	@NotBlank(message = "비밀번호는 빈 값일 수 없습니다")
	private String password;

	public Member toEntity() {
		return Member.builder()
			.username(this.username)
			.password(this.password)
			.build();
	}
}
