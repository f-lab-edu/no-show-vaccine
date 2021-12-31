package com.flab.nsv.member.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.flab.nsv.enums.UserRole;
import com.flab.nsv.domain.member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequestDto {
	@NotBlank(message = "아이디를 입력해주세요")
	@Pattern(regexp = "^[0-9a-z].{5,9}$", message = "영문 소문자, 숫자 6~10자 이내로 입력하세요.")
	private String username;

	@NotBlank(message = "비밀번호를 입력해주세요")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.*\\s).{8,12}$",
		message = "영문 대/소문자, 숫자, 특수문자를 1개 이상 포함하여 8-12자 이내로 입력하세요.")
	private String password;

	@NotBlank(message = "이름을 입력해주세요")
	private String name;

	@NotBlank(message = "생년월일을 입력해주세요")
	@Pattern(regexp = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$",
			message = "0000-00-00 형식으로 입력하세요.")
	private String birth;

	@NotNull(message = "성별을 선택해주세요. 'M'(Male), 'F'(Female)")
	private char gender;

	@NotBlank(message = "전화번호를 입력해주세요")
	@Pattern(regexp = "^(01[1|6|7|8|9|0])-(\\d{3,4})-(\\d{4})$",
			message = "010-0000-0000 형식으로 입력하세요.")
	private String telephone;

	public Member toEntity(String encryptedPassword) {
		Member member = Member.builder()
			.username(this.username)
			.password(encryptedPassword)
			.role(UserRole.MEMBER)
			.name(this.name)
			.birth(this.birth)
			.gender(this.gender)
			.telephone(this.telephone)
			.shotCount(0)
			.noShow('0')
			.lastUpdate(LocalDateTime.now())
			.build();
		return member;
	}

}
