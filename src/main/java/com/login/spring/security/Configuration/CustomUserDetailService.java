package com.login.spring.security.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.login.spring.security.Entity.RegisterUser;
import com.login.spring.security.Repository.RegisterUserRepository;

public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private RegisterUserRepository repository;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		RegisterUser registerUser = repository.findByEmail(email);
		if(registerUser==null) {
	    	 throw new UsernameNotFoundException("User Name is not found");
	     }else {
			return new CustomUser(registerUser);
		}
	}
}