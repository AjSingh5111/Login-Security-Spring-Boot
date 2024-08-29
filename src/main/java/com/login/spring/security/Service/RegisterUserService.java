package com.login.spring.security.Service;

import com.login.spring.security.Entity.RegisterUser;

public interface RegisterUserService {

	public RegisterUser saveRegisterUser(RegisterUser registerUser);
	public void removeSessionMessage();
}
