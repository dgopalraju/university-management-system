package com.universities.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universities.entity.Universities;

@Repository
public interface UniversityRepositary extends JpaRepository<Universities, Long> {

}
