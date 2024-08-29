package com.login.spring.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.login.spring.security.Entity.RegisterUser;
import com.login.spring.security.Repository.RegisterUserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
	@Autowired
	private RegisterUserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public RegisterUser saveRegisterUser(RegisterUser registerUser) {
	String password	= passwordEncoder.encode(registerUser.getPassword());
	registerUser.setPassword(password);
	registerUser.setRole("ROLE_USER");
		RegisterUser user = repository.save(registerUser);
		return user;
	}

	
	@Override
	public void removeSessionMessage() {
 HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
	.getRequest().getSession(); 
		session.removeAttribute("msg");
	}

}
