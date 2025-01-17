package com.cracovisit.controllets;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cracovisit.SpringConfig;
import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.SearchModel;
import com.cracovisit.services.AttractionServiceInterface;
import com.cracovisit.services.EventServiceInterface;
import com.cracovisit.services.LocationServiceInterface;
import com.cracovisit.services.MonumentServiceInterface;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/attractions")
public class AttractionController {
	
	@Autowired
	AttractionServiceInterface service;
	
	@Autowired
	LocationServiceInterface locationService;
	
	@Autowired
	MonumentServiceInterface monumentService;
	
	@Autowired
	EventServiceInterface eventService;


	@GetMapping
	public String showAllAtractions(Model model)
	{
		List<AttractionModel> attractions = service.getAttractions();
		
        model.addAttribute("title", "Lista zabytkow");
        model.addAttribute("attractions", attractions);
        model.addAttribute("searchModel", new SearchModel());
		
		return "attractions.html";
	}
	
	@PostMapping("/details")
	public String showDetails(AttractionModel attraction, Model model)
	{
		model.addAttribute("attraction", attraction);
		model.addAttribute("location", locationService.getByID(attraction.getAttractionLocation()));
		model.addAttribute("searchModel", new SearchModel());
		
		if(attraction.getAttractionType().equals("monument"))
		{
			model.addAttribute("monument", monumentService.getByID(attraction.getAttractionID()));
			return "attractionDetails.html";
		}
		else if(attraction.getAttractionType().equals("event"))
		{
			model.addAttribute("event", eventService.getByID(attraction.getAttractionID()));
			return "attractionDetailsEvent.html";
		}
		return null;
	}
	
	@GetMapping("/adminView")
	public String showAdminView(Model model)
	{
		List<AttractionModel> attractions = service.getAttractions();
		
        model.addAttribute("title", "Widok Administratora");
        model.addAttribute("attractions", attractions);
        model.addAttribute("searchModel", new SearchModel());
		
		return "adminView.html";
	}
	
	@GetMapping("/showNewAttractionForm")
	public String showNewAttractionForm(Model model)
	{
		model.addAttribute("attraction", new AttractionModel());
		model.addAttribute("searchModel", new SearchModel());
		
		return "addNewAttractionForm.html";
	}
	
	@PostMapping("/addNew")
	public String addNew(@Valid AttractionModel newAttraction, BindingResult bindingResult, Model model)
	{
		
		service.addAttraction(newAttraction);
		
		
		List<AttractionModel> attractions = service.getAttractions();
		model.addAttribute("title", "Lista zabytkow");
		model.addAttribute("attractions", attractions);
		model.addAttribute("searchModel", new SearchModel());
		
		return "attractions.html";
	}
	
	@PostMapping("/search")
	public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		List<AttractionModel> attractions = service.searchAttractions(searchModel.getSearchTerm());
		model.addAttribute("title", "Lista zabytkow");
		model.addAttribute("attractions", attractions);
		model.addAttribute("searchModel", new SearchModel());
		
		return "attractions.html";
	}
	
	@PostMapping("/delete")
	public String delete(@Valid AttractionModel attraction, BindingResult bindingResult, Model model)
	{
		service.deleteAttraction(attraction.getAttractionID());
		
		List<AttractionModel> attractions = service.getAttractions();
		model.addAttribute("title", "Widok Administratora");
		model.addAttribute("attractions", attractions);
		model.addAttribute("searchModel", new SearchModel());
		
		return "adminView.html";
	}
	
	@PostMapping("/showEditAttractionForm")
	public String showEditAttractionForm(@Valid AttractionModel attraction, BindingResult bindingResult, Model model)
	{

		model.addAttribute("attraction", attraction);
		model.addAttribute("searchModel", new SearchModel());
		
		return "editAttractionForm.html";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid AttractionModel attraction, BindingResult bindingResult, Model model)
	{
		service.updateAttraction(attraction, attraction.getAttractionID());
		
		List<AttractionModel> attractions = service.getAttractions();
		model.addAttribute("title", "Widok Administratora");
		model.addAttribute("attractions", attractions);
		model.addAttribute("searchModel", new SearchModel());
		
		return "adminView.html";
	}

}
