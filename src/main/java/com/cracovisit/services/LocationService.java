package com.cracovisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.LocationModel;

public class LocationService implements LocationServiceInterface{

	
	@Autowired
	private DataAccessInterface<LocationModel, Long> locationDao;
	
	@Override
	public LocationModel getByID(long id) {

		return locationDao.getByID(id);
	}

	@Override
	public List<LocationModel> getLocations() {
		
		return locationDao.getAll();
	}


	@Override
	public long addLocation(LocationModel e) {
		
		return locationDao.addNew(e);
	}

	@Override
	public boolean deleteLocation(long id) {
		
		return locationDao.deleteByID(id);
	}

	@Override
	public LocationModel updateLocation(LocationModel e, long id) {

		return locationDao.updateByID(e, id);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
