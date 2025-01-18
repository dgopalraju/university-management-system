package com.universities.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UniversityRequestDTO {

	@NotEmpty(message = "universityName cann't be null")
	private String universityName;

	@NotNull(message = "establishedYear cann't be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private LocalDate establishedYear;

	@NotEmpty(message = "universityType cann't be null")
	private String universityType;

	@NotEmpty(message = "address cann't be null")
	private String address;

	@NotEmpty(message = "mobileNumber cann't be null")
	@Pattern(regexp = "^[0-9]{10}$", message = "mobileNumber should be a 10-digit number")
	private String mobileNumber;

	@NotEmpty(message = "email cann't be null")
	@Email(message = "email not valid")
	private String email;

	@Size(max = 100, message = "founderName can be at most 100 characters")
	private String founderName;

	private String website;

}
