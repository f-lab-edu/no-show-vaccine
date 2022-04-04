package com.flab.nsv.common.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequestDto {
	@NotBlank(message = "비밀번호를 입력해주세요")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.*\\s).{8,12}$",
		message = "영문 대/소문자, 숫자, 특수문자를 1개 이상 포함하여 8-12자 이내로 입력하세요.")
	private String password;
}
