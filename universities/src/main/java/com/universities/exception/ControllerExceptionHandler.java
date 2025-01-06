package com.universities.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.universities.dto.ErrorResponseDTO;

import jakarta.validation.ValidationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException argumentException) {
		BindingResult result = argumentException.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		Map<String, String> validationErrors = new HashMap<>();
		for (FieldError fieldError : fieldErrors) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(LocalDateTime.now(), "Validation failed",
				validationErrors);
		return ResponseEntity.badRequest().body(errorResponse);
	}

	@ExceptionHandler(ValidationException.class)
	ResponseEntity<ErrorResponseDTO> handleValidationException(ValidationException exception) {
		Map<String, String> validationErrors = new HashMap<>();
		validationErrors.put("universityId", exception.getMessage());
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(null, null, validationErrors);
		return ResponseEntity.badRequest().body(errorResponse);
	}

}
