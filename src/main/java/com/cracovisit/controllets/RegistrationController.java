package com.cracovisit.controllets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cracovisit.models.UserModel;
import com.cracovisit.services.UserServiceInterface;

@Controller
public class RegistrationController {
	
	@Autowired
	UserServiceInterface service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping(value = "/req/signup", consumes = "application/json")
	public String createUser(@RequestBody UserModel user)
	{
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		service.addUser(user);
		return "loginForm.html";
	}
}