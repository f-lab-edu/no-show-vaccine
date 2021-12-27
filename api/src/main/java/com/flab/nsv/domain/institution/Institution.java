package com.flab.nsv.domain.institution;

import java.math.BigDecimal;
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
	private String telephone;
	private String address;
	private String openTime;
	private String closingTime;
	private double longitude;
	private double latitude;
	private LocalDateTime lastUpdate;

	public void changeTelephone(String telephone) { this.telephone = telephone; }

	public void changeOpenTime(String openTime) { this.openTime = openTime; }

	public void changeClosingTime(String closingTime) { this.closingTime = closingTime; }

	public void location(BigDecimal lng, BigDecimal lat) {
		longitude = lng.doubleValue();
		latitude = lat.doubleValue();
	}

	public void location(String lng, String lat) {
		longitude = Double.parseDouble(lng);
		latitude = Double.parseDouble(lat);
	}
}