package com.flab.nsv.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.domain.vaccine.Vaccine;
import com.flab.nsv.member.dto.CreateVaccineRequestDto;
import com.flab.nsv.member.service.VaccineService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vaccine")
public class VaccineController {

	private final VaccineService vaccineService;

	@PostMapping("/registration")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerVaccine(CreateVaccineRequestDto createVaccineRequestDto) {
		vaccineService.registerVaccine(createVaccineRequestDto);
	}

	@GetMapping("/{id}")
	public Vaccine getById(@PathVariable("id") final long id) {
		return vaccineService.getById(id);
	}
}
