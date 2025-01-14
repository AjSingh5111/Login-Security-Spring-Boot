package com.login.spring.security.Configuration;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	java.util.Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
	if(roles.contains("ROLE_ADMIN")) {
	response.sendRedirect("/admin/profile");	
	}
	else {
	response.sendRedirect("/user/profile");	
	}
	}

}
