package com.flab.nsv.domain.reservation;

import com.flab.nsv.domain.institution.Institution;
import com.flab.nsv.domain.member.Member;
import com.flab.nsv.domain.vaccine.Vaccine;

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
public class Reservation {
	private Long id;
	private Member member;
	private Institution institution;
	private Vaccine vaccine;
	private String date;
	private int status;
}