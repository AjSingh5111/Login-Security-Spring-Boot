package com.login.spring.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.spring.security.Entity.RegisterUser;
import java.util.List;


public interface RegisterUserRepository extends JpaRepository<RegisterUser, Integer>{

	public RegisterUser findByEmail(String email);
}
