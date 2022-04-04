package com.flab.nsv.member.dto;

import java.time.LocalDateTime;

import com.flab.nsv.common.user.dto.UserResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
	private UserResponseDto userResponse;
	private String name;
	private String birth;
	private char gender;
	private String telephone;
	private int shotCount;
	private LocalDateTime vaccinationDate;
	private char noShow;
	private LocalDateTime lastUpdate;
}
