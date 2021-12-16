package com.flab.nsv.domain.member;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Member {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String dateOfBirth;
	private char gender;
	private String phoneNumber;
	private LocalDateTime regAt;
	private LocalDateTime modAt;
}
