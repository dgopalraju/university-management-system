package com.universities.mapper;

import org.mapstruct.Mapper;

import com.universities.dto.UniversityRequestDTO;
import com.universities.dto.UniversityResponseDTO;
import com.universities.entity.Universities;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

	Universities toEntity(UniversityRequestDTO dto);

	UniversityRequestDTO toDTO(Universities entity);

	UniversityResponseDTO toResponseDTO(Universities entity);
}
