package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.institution.Stock;
import com.flab.nsv.member.dto.CreateStockRequestDto;
import com.flab.nsv.member.exception.NotFoundStockException;
import com.flab.nsv.system.mapper.StockMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockService {
	private final StockMapper stockMapper;

	public void inputData(CreateStockRequestDto createStockRequestDto) {
		Stock stock = stockMapper.toEntity(createStockRequestDto);
	}

	public Stock getByInstitutionId(long id) {
		return stockMapper.getByInstitutionId(id).orElseThrow(NotFoundStockException::new);
	}
}
