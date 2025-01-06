package com.universities.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
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

}
