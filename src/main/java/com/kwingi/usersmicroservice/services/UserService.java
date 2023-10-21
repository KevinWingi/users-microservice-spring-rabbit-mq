package com.kwingi.usersmicroservice.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwingi.usersmicroservice.entities.UserEntity;
import com.kwingi.usersmicroservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired private UserRepository userRepository;
	
	public UserEntity save(UserEntity user) {
		user.setId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}
	
}
