package com.flab.nsv.system.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flab.nsv.domain.institution.Institution;
import com.flab.nsv.domain.member.Member;

@Mapper
public interface InstitutionMapper {
	// List<Institution> findNearInstitutions( @Param("curLatitude") Double curLatitude,
	// 										@Param("curLongitude") Double curLongitude,
	// 										@Param("radius") int radius);
	long createInstitution(Institution institution);

	void updateInstitution(Institution institution);

	Optional<Institution> getById(long id);
}
