package com.universities.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.universities.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniversityResponseDTO {

	private Long universityId;
	private String universityName;
	private LocalDate establishedYear;
	private String universityType;
	private String address;
	private String mobileNumber;
	private String email;
	private String founderName;
	private String website;
	private String createdBy;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private String modifiedBy;

}
