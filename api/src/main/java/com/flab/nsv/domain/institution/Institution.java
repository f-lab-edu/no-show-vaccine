package com.flab.nsv.domain.institution;

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
public class Institution {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String corpNum;
	private String telephone;
	private String address;
	private String openTime;
	private String closeTime;
	private Location location;
	private LocalDateTime lastUpdate;
}