package com.kwingi.usersmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kwingi.usersmicroservice.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	boolean existsByEmail(String email);
}
