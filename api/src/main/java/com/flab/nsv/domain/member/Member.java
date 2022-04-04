package com.flab.nsv.domain.member;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.flab.nsv.domain.common.User;
import com.flab.nsv.enums.UserRole;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends User {
	private String name;
	private String birth;
	private char gender;
	private String telephone;
	private int shotCount;
	private LocalDateTime vaccinationDate;
	private char noShow;
	private LocalDateTime lastUpdate;

	@Builder
	public Member(Long id, String username, String password, UserRole role,
		String name, String birth, char gender, String telephone, int shotCount,
		LocalDateTime vaccinationDate, char noShow, LocalDateTime lastUpdate) {
		super(id, username, password, role);
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.telephone = telephone;
		this.shotCount = shotCount;
		this.vaccinationDate = vaccinationDate;
		this.noShow = noShow;
		this.lastUpdate = lastUpdate;
	}
}
