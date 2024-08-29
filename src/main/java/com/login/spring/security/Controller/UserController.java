package com.login.spring.security.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.spring.security.Entity.RegisterUser;
import com.login.spring.security.Repository.RegisterUserRepository;

@Controller
@RequestMapping("/user/")
public class UserController {
	
@Autowired	
private RegisterUserRepository repository;
	
	@ModelAttribute
	public void commonUser(Principal p, Model model) {
		
		if(p!=null) {
			String email = p.getName();
			RegisterUser regUser = repository.findByEmail(email);	
			model.addAttribute("regUser", regUser);	
		}	
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

}
