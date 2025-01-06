package com.universities.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.universities.dto.ResponseDTO;
import com.universities.dto.UniversityRequestDTO;
import com.universities.dto.UniversityResponseDTO;
import com.universities.entity.Universities;
import com.universities.mapper.UniversityMapper;
import com.universities.repositary.UniversityRepositary;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

	private final UniversityRepositary universityRepositary;
	private final UniversityMapper universityMapper;

	@Override
	public ResponseDTO createUniversity(UniversityRequestDTO universityRequestDTO) {
		Universities universities = universityMapper.toEntity(universityRequestDTO);
		universities = universityRepositary.save(universities);
		ResponseDTO responseDTO = new ResponseDTO(universities.getUniversityId(), "University Registerd Successfully.");
		return responseDTO;
	}

	@Override
	public List<UniversityResponseDTO> fetchAllUniversityDetails() {
		List<Universities> universities = universityRepositary.findAll();
		return universities.stream().map(university -> {
			return universityMapper.toResponseDTO(university);
		}).collect(Collectors.toList());
	}

	@Override
	public UniversityResponseDTO fetchUniversityDetails(Long universityId) {
		Universities universities = validateUniversityById(universityId);
		return universityMapper.toResponseDTO(universities);
	}

	@Override
	public ResponseDTO updateUniversityDetails(Long universityId, UniversityRequestDTO universityRequestDTO) {
		Universities existingUniversity = validateUniversityById(universityId);
		existingUniversity = universityMapper.toEntity(universityRequestDTO);
		existingUniversity.setUniversityId(universityId);
		universityRepositary.save(existingUniversity);
		return new ResponseDTO(universityId, "University Updated Successfully.");
	}

	@Override
	public ResponseDTO deleteUniversity(Long universityId) {
		validateUniversityById(universityId);
		universityRepositary.deleteById(universityId);
		return new ResponseDTO(universityId, "University Deleted Successfully.");
	}

	private Universities validateUniversityById(Long universityId) {
		Universities universities = universityRepositary.findById(universityId)
				.orElseThrow(() -> new ValidationException("Following with universityId we can't find any details"));
		return universities;
	}

}
