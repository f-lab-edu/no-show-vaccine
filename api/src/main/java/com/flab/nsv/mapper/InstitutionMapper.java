package com.flab.nsv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flab.nsv.domain.institution.Institution;

@Mapper
public interface InstitutionMapper {
	List<Institution> findNearInstitutions( @Param("curLatitude") Double curLatitude,
											@Param("curLongitude") Double curLongitude,
											@Param("radius") int radius);
}
