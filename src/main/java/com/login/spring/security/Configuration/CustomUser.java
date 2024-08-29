package com.login.spring.security.Configuration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.login.spring.security.Entity.RegisterUser;

public class CustomUser implements UserDetails {
	
	private RegisterUser registerUser;
	
	

	public CustomUser(RegisterUser registerUser) {
		super();
		this.registerUser = registerUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
SimpleGrantedAuthority authority = new SimpleGrantedAuthority(registerUser.getRole());
		
		return Arrays.asList(authority);
		
	}

	@Override
	public String getPassword() {
		
		return registerUser.getPassword();
	}

	@Override
	public String getUsername() {
		
		return registerUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
