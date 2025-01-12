package com.cracovisit.controllets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.FeedbackModel;
import com.cracovisit.models.SearchModel;
import com.cracovisit.models.UserModel;
import com.cracovisit.services.AttractionServiceInterface;
import com.cracovisit.services.FeedbackServiceInterface;
import com.cracovisit.services.UserServiceInterface;
import com.cracovisit.utils.UserUtils;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	AttractionServiceInterface attractionService;
	
	@Autowired
	FeedbackServiceInterface feedbackService;
	
	@Autowired
	UserServiceInterface userService;
	
	@PostMapping
	public String showAllAtractions(Model model, AttractionModel attraction)
	{
		List<FeedbackModel> opinions = feedbackService.searchFeedbacks(attraction.getAttractionID());
		
        model.addAttribute("attraction", attraction);
        model.addAttribute("opinions", opinions);
        model.addAttribute("searchModel", new SearchModel());
		
		return "feedbacks.html";
	}
	
	@PostMapping("/add")
	public String addNewFeedback(@Valid FeedbackModel newFeedback, BindingResult bindingResult, AttractionModel attraction, Model model)
	{
		String email = UserUtils.getLoggedInUsername();
		System.out.println(email);
		Optional<UserModel> user = userService.getUserByEmail(email);
		
		FeedbackModel feedback = newFeedback;
		feedback.setUserID(user.get().getUserID());
		
		feedback.setAttractionID(attraction.getAttractionID());
		
		System.out.println(feedback.getAttractionID());
		
		feedbackService.addFeedback(feedback);
		
		List<FeedbackModel> opinions = feedbackService.searchFeedbacks(attraction.getAttractionID());
		
        model.addAttribute("attraction", attraction);
        model.addAttribute("opinions", opinions);
        model.addAttribute("searchModel", new SearchModel());
		
		return "feedbacks.html";
	}



}
