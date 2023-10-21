package com.kwingi.usersmicroservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO (
		@NotBlank(message = "Name required")
		String name, 
		
		@Email(message = "Invalid email")
		@NotBlank(message = "Email required")
		String email) {}
