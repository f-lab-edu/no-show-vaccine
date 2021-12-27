package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.vaccine.Vaccine;
import com.flab.nsv.member.dto.CreateVaccineRequestDto;
import com.flab.nsv.member.exception.NotFoundVaccineException;
import com.flab.nsv.system.mapper.VaccineMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VaccineService {
	private final VaccineMapper vaccineMapper;

	public void registerVaccine(CreateVaccineRequestDto createVaccineRequestDto) {
		Vaccine vaccine = createVaccineRequestDto.toEntity();
		vaccineMapper.registerVaccine(vaccine);
	}

	public Vaccine getById(long id) {
		return vaccineMapper.getById(id).orElseThrow(NotFoundVaccineException::new);
	}
}
