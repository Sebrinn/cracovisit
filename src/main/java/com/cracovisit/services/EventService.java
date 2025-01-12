package com.cracovisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.EventModel;

public class EventService implements EventServiceInterface{

	
	@Autowired
	private DataAccessInterface<EventModel, Long> EventDAO;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventModel> getEvents() {

		return EventDAO.getAll();
	}

	@Override
	public long addEvent(EventModel e) {

		return EventDAO.addNew(e);
	}

	@Override
	public boolean deleteEvent(long id) {
		
		return EventDAO.deleteByID(id);
	}

	@Override
	public EventModel updateEvent(EventModel e, long id) {
		
		return EventDAO.updateByID(e, id);
	}

	@Override
	public EventModel getByID(long id) {

		return EventDAO.getByID(id);
	}

}
