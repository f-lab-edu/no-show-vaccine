package com.flab.nsv.member.dto;

import java.util.Optional;
import java.util.function.Predicate;

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
public class UpdateMemberRequestDto {

	@NotBlank(message = "비밀번호를 입력해주세요")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.*\\s).{8,12}$",
		message = "영문 대/소문자, 숫자, 특수문자를 1개 이상 포함하여 8-12자 이내로 입력하세요.")
	private String password;

	@NotBlank(message = "전화번호를 입력해주세요")
	@Pattern(regexp = "^(01[1|6|7|8|9|0])-(\\d{3,4})-(\\d{4})$",
		message = "010-0000-0000 형식으로 입력하세요.")
	private String telephone;

	public Optional<String> getUpdatePassword() {
		return Optional.ofNullable(password).filter(Predicate.not(String::isBlank));
	}

	public Optional<String> getUpdateTelephone() {
		return Optional.ofNullable(telephone).filter(Predicate.not(String::isBlank));
	}
}
