package com.flab.nsv.member.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStockRequestDto {
	private long institutionId;
	private long vaccineId;
	private int quantity;
	private LocalDateTime lastUpdate;

	public void changeQuantity(int quantity) { this.quantity = quantity; }

	public void addQuantity() { this.quantity++; }

	public void subQuantity() { this.quantity--; }
}
