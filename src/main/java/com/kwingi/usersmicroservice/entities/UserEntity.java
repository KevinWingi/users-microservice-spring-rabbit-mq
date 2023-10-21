package com.kwingi.usersmicroservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class UserEntity {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
}
