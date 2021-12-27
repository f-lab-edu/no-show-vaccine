package com.flab.nsv.system.mapper;

import java.util.Optional;

import com.flab.nsv.domain.vaccine.Vaccine;

public interface VaccineMapper {
	Optional<Vaccine> getById(long id);

	long registerVaccine(Vaccine vaccine);
}
