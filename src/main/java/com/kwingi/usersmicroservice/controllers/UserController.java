package com.kwingi.usersmicroservice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwingi.usersmicroservice.dtos.UserRecordDTO;
import com.kwingi.usersmicroservice.entities.UserEntity;
import com.kwingi.usersmicroservice.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired private UserService userService;

	@PostMapping
	public ResponseEntity<UserEntity> save(@RequestBody @Valid UserRecordDTO dto) {
		var user = new UserEntity();
		BeanUtils.copyProperties(dto, user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
}
