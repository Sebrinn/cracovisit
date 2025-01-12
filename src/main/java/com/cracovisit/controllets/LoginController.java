package com.cracovisit.controllets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cracovisit.models.UserModel;
import com.cracovisit.models.SearchModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class LoginController {
	
	@GetMapping("/login")
	public String displayLoginForm(Model model)
	{
		return "loginForm.html";
	}
	


}
