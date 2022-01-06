package com.flab.nsv.member.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.domain.institution.Stock;
import com.flab.nsv.member.dto.CreateStockRequestDto;
import com.flab.nsv.member.service.StockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockController {
	private final StockService stockService;

	@PostMapping("/input")
	public void inputData(@Valid @RequestBody final CreateStockRequestDto createStockRequestDto) {
		stockService.inputData(createStockRequestDto);
	}

	@GetMapping("/institution/{id}")
	public Stock getByInstitutionId(@PathVariable("id") final long id) {
		return stockService.getByInstitutionId(id);
	}

	@PutMapping("/{id}")
	public void updateStock() {

	}
}
