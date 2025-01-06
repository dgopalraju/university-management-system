package com.universities.service;

import java.util.List;

import com.universities.dto.ResponseDTO;
import com.universities.dto.UniversityRequestDTO;
import com.universities.dto.UniversityResponseDTO;

import jakarta.validation.Valid;

public interface UniversityService {

	ResponseDTO createUniversity(@Valid UniversityRequestDTO universityRequestDTO);

	List<UniversityResponseDTO> fetchAllUniversityDetails();

	UniversityResponseDTO fetchUniversityDetails(Long universityId);

	ResponseDTO updateUniversityDetails(Long universityId, UniversityRequestDTO universityRequestDTO);

	ResponseDTO deleteUniversity(Long universityId);

}
