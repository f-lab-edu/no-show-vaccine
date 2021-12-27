package com.flab.nsv.member.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.domain.institution.Institution;
import com.flab.nsv.member.dto.CreateInstitutionRequestDto;
import com.flab.nsv.member.dto.UpdateInstitutionRequestDto;
import com.flab.nsv.member.service.InstitutionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/institution")
public class InstitutionController {

	private final InstitutionService institutionService;

	@PostMapping("/join")
	@ResponseStatus(HttpStatus.CREATED)
	public void joinInstitution(@Valid @RequestBody final CreateInstitutionRequestDto createInstitutionRequestDto) {
		institutionService.joinInstitution(createInstitutionRequestDto);
	}

	@GetMapping("/{id}")
	public Institution getById(@PathVariable("id") final long id) {
		return institutionService.getById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateInstitution(
		@PathVariable("id") final long id,
		@Valid @RequestBody final UpdateInstitutionRequestDto updateInstituionRequestDto) {
		institutionService.updateInstitution(id, updateInstituionRequestDto);
	}
}
