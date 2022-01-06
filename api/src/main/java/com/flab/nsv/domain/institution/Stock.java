package com.flab.nsv.domain.institution;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Embedded;

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
	@Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
	private Institution institution;

	@Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
	private Vaccine vaccine;

	private int quantity;

	private LocalDateTime lastUpdate;

	public void addStock() { this.quantity++; }

	public void subStock() { this.quantity--; }

	public void changeStock(int quantity) { this.quantity = quantity; }
}
