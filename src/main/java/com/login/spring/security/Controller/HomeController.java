package com.login.spring.security.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.login.spring.security.Entity.RegisterUser;
import com.login.spring.security.Repository.RegisterUserRepository;
import com.login.spring.security.Service.RegisterUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HomeController {
	
	@Autowired
	private RegisterUserService registerUserService;
	
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
	

	@GetExchange("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "register";	
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	@GetMapping("/user/profile")
//	public String profile(Principal p, Model model){
//		String email = p.getName();
//	RegisterUser regUser = repository.findByEmail(email);
//	model.addAttribute("regUser", regUser);
//		return "profile";
//	}
//	
//	@GetMapping("/user/home")
//	public String home() {
//		return "home";
//	}
	
	@PostMapping("/saveUser")
	public String saveRegisterUser(@ModelAttribute RegisterUser registerUser, HttpSession session) 
	{
		RegisterUser user = registerUserService.saveRegisterUser(registerUser);
		
		if(user!=null) {
			//System.out.println("Save Successfully");
	session.setAttribute("msg", "Register Successfully");
		}else {
			//System.out.println("Error in Server");
	session.setAttribute("msg", "Something wrong!!");
		}
		
		return "register";
		
	}
}
