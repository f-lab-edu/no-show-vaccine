package com.flab.nsv.domain.member;

import java.io.Serializable;

import com.flab.nsv.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthMember implements Serializable {
	private String username;
	private UserRole role;
}
