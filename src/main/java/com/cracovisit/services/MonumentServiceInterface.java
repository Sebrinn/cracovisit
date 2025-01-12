package com.cracovisit.services;

import java.util.List;

import com.cracovisit.models.MonumentModel;

public interface MonumentServiceInterface {

	public MonumentModel getByID(long id);
	public List<MonumentModel> getMonuments();
	public long addMonument(MonumentModel e);
	public boolean deleteMonument(long id);
	public MonumentModel updateMonument(MonumentModel e, long id);
		
	public void init();
	public void destroy();

}
