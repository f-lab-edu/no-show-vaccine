package com.flab.nsv.system.mapper;

import java.util.Optional;

import com.flab.nsv.domain.institution.Stock;

public interface StockMapper {
	Optional<Stock> getByInstitutionId(long id);
}
