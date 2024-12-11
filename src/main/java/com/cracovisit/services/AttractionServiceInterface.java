package com.cracovisit.services;

import java.util.List;

import com.cracovisit.models.AttractionModel;

public interface AttractionServiceInterface {

	public AttractionModel getByID(long id);
	public List<AttractionModel> getAttractions();
	public List<AttractionModel> searchAttractions(String searchTerm);
	public long addAttraction(AttractionModel e);
	public boolean deleteAttraction(long id);
	public AttractionModel updateAttraction(AttractionModel e, long id);
	
	public void init();
	public void destroy();
	
}
