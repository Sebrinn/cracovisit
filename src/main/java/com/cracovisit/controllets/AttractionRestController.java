package com.cracovisit.controllets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cracovisit.models.AttractionModel;
import com.cracovisit.services.AttractionServiceInterface;



@RestController
@RequestMapping("/api/v1/attractions")
public class AttractionRestController {
	
	@Autowired
	AttractionServiceInterface service;


	@GetMapping
	public List<AttractionModel> showAllAtractions(Model model)
	{
		List<AttractionModel> attractions = service.getAttractions();
		
		
		return attractions;
	}
	
	@GetMapping("/search/{searchTerm}")
	public List<AttractionModel> searchAttraction(@PathVariable(name = "searchTerm") String searchTerm)
	{
		List<AttractionModel> attractions = service.searchAttractions(searchTerm);
		
		
		return attractions;
	}
	
	@PostMapping("/")
	public long addAttraction(@RequestBody AttractionModel e)
	{
		return service.addAttraction(e);
	}
	
	@GetMapping("/getById/{id}")
	public AttractionModel getByID(@PathVariable(name = "id") long id)
	{
		return service.getByID(id);
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteAttraction(@PathVariable(name = "id") long id) {
		return service.deleteAttraction(id);
	}
	
	@PutMapping("/update/{id}")
	public AttractionModel updateAttraction(@PathVariable(name = "id") long id, @RequestBody AttractionModel e) {
		return service.updateAttraction(e, id);
	}
	

}
