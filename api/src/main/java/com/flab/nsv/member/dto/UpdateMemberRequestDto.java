package com.flab.nsv.member.dto;

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

	@NotBlank(message = "전화번호를 입력해주세요")
	@Pattern(regexp = "^(01[1|6|7|8|9|0])-(\\d{3,4})-(\\d{4})$",
		message = "010-0000-0000 형식으로 입력하세요.")
	private String telephone;
}
