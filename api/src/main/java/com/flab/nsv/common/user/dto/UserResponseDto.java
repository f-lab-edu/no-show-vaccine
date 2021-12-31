package com.flab.nsv.common.user.dto;

import com.flab.nsv.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	private Long userId;
	private String username;
	private String password;
	private UserRole role;
}
