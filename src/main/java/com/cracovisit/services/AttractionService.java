package com.cracovisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.AttractionModel;

public class AttractionService implements AttractionServiceInterface{

	@Autowired
	private DataAccessInterface<AttractionModel, String> attractionDao;
	
	
	@Override
	public List<AttractionModel> getAttractions() {
		
		return attractionDao.getAll();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttractionModel getByID(long id) {
		return attractionDao.getByID(id);
	}

	@Override
	public List<AttractionModel> searchAttractions(String searchTerm) {
		
		return attractionDao.search(searchTerm);
	}

	@Override
	public long addAttraction(AttractionModel e) {
		return attractionDao.addNew(e);
		
	}

	@Override
	public boolean deleteAttraction(long id) {
		return attractionDao.deleteByID(id);
	}

	@Override
	public AttractionModel updateAttraction(AttractionModel e, long id) {
		
		return attractionDao.updateByID(e, id);
	}

}
