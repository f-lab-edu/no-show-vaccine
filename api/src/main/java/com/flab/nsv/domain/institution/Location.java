package com.flab.nsv.domain.institution;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	private double longitude;
	private double latitude;

	public Location(BigDecimal lng, BigDecimal lat) {
		longitude = lng.doubleValue();
		latitude = lat.doubleValue();
	}

	public Location(String lng, String lat) {
		longitude = Double.parseDouble(lng);
		latitude = Double.parseDouble(lat);
	}

	@Override
	public String toString() {
		return "point(" + longitude + " " + latitude + ")";
	}
}
