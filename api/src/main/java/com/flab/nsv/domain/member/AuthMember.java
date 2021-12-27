package com.flab.nsv.domain.member;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthMember implements Serializable {
	private Long id;
	private String username;
	private int shotCount;
	private char noShow;
}
