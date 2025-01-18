package com.universities.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = true)
public class Universities extends BaseEntity {

	@Id
	private Long universityId;
	private String universityName;
	private LocalDate establishedYear;
	private String universityType;
	private String address;
	private String mobileNumber;
	private String email;
	private String founderName;
	private String website;

	@PrePersist
	public void generateId() {
		if (universityId == null) {
			this.universityId = 1000000000L + (long) (Math.random() * 9000000000L);
		}
	}

}
