package com.cracovisit.controllets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cracovisit.models.UserModel;
import com.cracovisit.services.UserServiceInterface;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/req")
public class RegistrationController {
	
	@Autowired
	UserServiceInterface service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String displaySignupForm(Model model)
	{
		return "signup.html";
	}
	
	@PostMapping(value = "signup/admit", consumes = "application/json")
	public ResponseEntity<Map<String, String>> createUser(@RequestBody UserModel user)
	{
	    user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
	    service.addUser(user);

	    // Zwracamy odpowiedź JSON
	    Map<String, String> response = new HashMap<>();
	    response.put("status", "success");
	    response.put("redirectUrl", "/login");
	    return ResponseEntity.ok(response);
	}
}