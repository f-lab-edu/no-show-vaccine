package com.flab.nsv.domain.member;

import java.time.LocalDateTime;

import com.flab.nsv.domain.institution.Location;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("checkstyle:RightCurly")
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
	private int shotCount;
	private LocalDateTime vaccinationDate;
	private char noShow;
	private LocalDateTime lastUpdate;

	public void changePassword(String password) {
		this.password = password;
	}

	public void changeTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void addShotCount() {
		this.shotCount++;
	}

	public void changeNoShow() {
		this.noShow = 1;
	}
}
