package com.flab.nsv.domain.member;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String birth;
	private char gender;
	private String telephone;
	private int shot;
	private char noShow;
	private LocalDateTime lastUpdate;
}
