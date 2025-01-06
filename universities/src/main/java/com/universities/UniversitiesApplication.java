package com.universities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UniversitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversitiesApplication.class, args);
	}

}
