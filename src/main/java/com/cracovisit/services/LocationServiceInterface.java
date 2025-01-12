package com.cracovisit.services;

import java.util.List;

import com.cracovisit.models.LocationModel;

public interface LocationServiceInterface {

	public LocationModel getByID(long id);
	public List<LocationModel> getLocations();
	public long addLocation(LocationModel e);
	public boolean deleteLocation(long id);
	public LocationModel updateLocation(LocationModel e, long id);
		
	public void init();
	public void destroy();

}
