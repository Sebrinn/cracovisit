package com.cracovisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.LocationModel;
import com.cracovisit.models.MonumentModel;

public class MonumentService implements MonumentServiceInterface{

	
	@Autowired
	private DataAccessInterface<MonumentModel, Long> monumentDAO;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MonumentModel> getMonuments() {

		return monumentDAO.getAll();
	}

	@Override
	public long addMonument(MonumentModel e) {

		return monumentDAO.addNew(e);
	}

	@Override
	public boolean deleteMonument(long id) {
		
		return monumentDAO.deleteByID(id);
	}

	@Override
	public MonumentModel updateMonument(MonumentModel e, long id) {
		
		return monumentDAO.updateByID(e, id);
	}

	@Override
	public MonumentModel getByID(long id) {

		return monumentDAO.getByID(id);
	}

}
