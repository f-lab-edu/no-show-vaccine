package com.flab.nsv.member.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.institution.Institution;
import com.flab.nsv.member.dto.CreateInstitutionRequestDto;
import com.flab.nsv.member.dto.UpdateInstitutionRequestDto;
import com.flab.nsv.member.exception.NotFoundInstitutionException;
import com.flab.nsv.system.mapper.InstitutionMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstitutionService {
	private final InstitutionMapper institutionMapper;

	public void joinInstitution(CreateInstitutionRequestDto createInstitutionRequestDto) {
		Institution institution = createInstitutionRequestDto.toEntity();
		institutionMapper.createInstitution(institution);
	}

	public Institution getById(long id) {
		return institutionMapper.getById(id).orElseThrow(NotFoundInstitutionException::new);
	}

	public void updateInstitution(long id, UpdateInstitutionRequestDto updateInstituionRequestDto) {
		Institution institution = institutionMapper.getById(id).orElseThrow(NotFoundInstitutionException::new);

		//TODO : update fields

		institutionMapper.updateInstitution(institution);
	}
}
