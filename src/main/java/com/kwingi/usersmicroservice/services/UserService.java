package com.kwingi.usersmicroservice.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwingi.usersmicroservice.entities.UserEntity;
import com.kwingi.usersmicroservice.producers.UserProducer;
import com.kwingi.usersmicroservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired private UserRepository userRepository;
	
	@Autowired private UserProducer userProducer;
		
	@Transactional
	public UserEntity save(UserEntity user) {
		if (userRepository.existsByEmail(user.getEmail()))
			throw new IllegalArgumentException(String.format("Already exist user with %s", user.getEmail()));
		
		user.setId(UUID.randomUUID().toString());
		UserEntity createdUser = userRepository.save(user);
		
		userProducer.sendWelcomeEmail(createdUser);
		
		return createdUser;
	}
	
}
