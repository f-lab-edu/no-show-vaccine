package com.flab.nsv.domain.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthMember implements Serializable {
	private Long id;
	private String username;
	private int shotCount;
	private char noShow;

	public AuthMember(Member member) {
		this.id = member.getId();
		this.username = member.getUsername();
		this.shotCount = member.getShotCount();
		this.noShow = member.getNoShow();
	}
}
