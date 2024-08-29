package com.login.spring.security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class RegisterUser {
	
	@Id
	private int id;
	
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String role;
	

}
