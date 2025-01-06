package com.universities.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universities.dto.ResponseDTO;
import com.universities.dto.UniversityRequestDTO;
import com.universities.dto.UniversityResponseDTO;
import com.universities.service.UniversityService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/universities")
@Validated
public class UniversityController {

	private final UniversityService universityService;

	@PostMapping
	ResponseEntity<ResponseDTO> createUniversity(@Valid @RequestBody UniversityRequestDTO universityRequestDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(universityService.createUniversity(universityRequestDTO));
	}

	@GetMapping
	ResponseEntity<List<UniversityResponseDTO>> fetchAllUniversityDetails() {
		return ResponseEntity.ok(universityService.fetchAllUniversityDetails());
	}

	@GetMapping("{universityId}")
	ResponseEntity<UniversityResponseDTO> fetchUniversityDetails(@PathVariable(required = true) Long universityId) {
		validateUniversityId(universityId);
		return ResponseEntity.ok(universityService.fetchUniversityDetails(universityId));
	}

	@PutMapping("{universityId}")
	ResponseEntity<ResponseDTO> updateUniversityDetails(@PathVariable(required = true) Long universityId,
			@Valid @RequestBody UniversityRequestDTO universityRequestDTO) {
		validateUniversityId(universityId);
		return ResponseEntity.ok(universityService.updateUniversityDetails(universityId, universityRequestDTO));
	}

	@DeleteMapping("{universityId}")
	ResponseEntity<ResponseDTO> deleteUniversity(@PathVariable(required = true) Long universityId) {
		validateUniversityId(universityId);
		return ResponseEntity.ok(universityService.deleteUniversity(universityId));
	}
	
	private void validateUniversityId(Long universityId) {
		if (null == universityId || universityId <= 0) {
			throw new ValidationException("universityId can't be null must be a valid positive number");
		}
	}

}
