package com.flab.nsv.member.dto;

import javax.validation.constraints.NotBlank;

import com.flab.nsv.domain.vaccine.Vaccine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVaccineRequestDto {
	private Long id;

	@NotBlank(message = "백신 코드를 입력해주세요")
	private String code;

	@NotBlank(message = "백신 이름을 입력해주세요")
	private String name;

	public Vaccine toEntity() {
		Vaccine vaccine = Vaccine.builder()
			.code(this.code)
			.name(this.name)
			.build();
		return vaccine;
	}
}
