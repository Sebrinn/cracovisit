package com.cracovisit.services;

import java.util.List;

import com.cracovisit.models.EventModel;

public interface EventServiceInterface {

	public EventModel getByID(long id);
	public List<EventModel> getEvents();
	public long addEvent(EventModel e);
	public boolean deleteEvent(long id);
	public EventModel updateEvent(EventModel e, long id);
		
	public void init();
	public void destroy();

}
