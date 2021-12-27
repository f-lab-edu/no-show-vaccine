package com.flab.nsv.member.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.flab.nsv.domain.institution.Institution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstitutionRequestDto {
	@NotBlank(message = "기관명을 입력해주세요")
	private String name;

	@NotBlank(message = "전화번호를 입력해주세요")
	@Pattern(regexp = "^((0\\d{1,2})-(\\d{3,4})|(\\d{4}))-(\\d{4})$",
			 message = "000-0000-0000 또는 0000-0000 형식으로 입력하세요.")
	private String telephone;

	@NotBlank(message = "주소를 입력해주세요")
	private String address;

	@NotBlank(message = "여는 시간을 입력해주세요")
	private String open_time;

	@NotBlank(message = "닫는 시간을 입력해주세요")
	private String closing_time;

	private Double latitude;

	private Double longitude;

	public Institution toEntity() {
		Institution institution = Institution.builder()
			.name(this.name)
			.telephone(this.telephone)
			.address(this.address)
			.openTime(this.open_time)
			.closingTime(this.closing_time)
			.latitude(this.latitude)
			.longitude(this.longitude)
			.build();
		return institution;
	}
}
