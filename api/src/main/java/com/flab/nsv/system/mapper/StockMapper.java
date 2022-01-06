package com.flab.nsv.system.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;

import com.flab.nsv.domain.institution.Stock;
import com.flab.nsv.member.dto.CreateStockRequestDto;

@Mapper(componentModel = "spring")
public interface StockMapper extends GenericMapper<CreateStockRequestDto, Stock>{
	Optional<Stock> getByInstitutionId(long id);
}