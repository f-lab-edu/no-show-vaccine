package com.flab.nsv.domain.institution;

import java.time.LocalDateTime;

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
public class Stock {
	private Institution institution;
	private Vaccine vaccine;
	private int quantity;
	private LocalDateTime lastUpdate;
}
