package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.EventModel;
import com.cracovisit.models.EventEntity;

public class EventDAO implements DataAccessInterface<EventModel, Long>{
	
	@Autowired
	EventRepositoryInterface repository;
	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public EventDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public EventModel getByID(long id) {
		
		EventEntity entity = repository.findById(id).orElse(null);
		
		EventModel model = mapper.map(entity, EventModel.class);
		
		return model;
	}

	@Override
	public List<EventModel> getAll() {
		
		Iterable<EventEntity> EventsEntity = repository.findAll();
		
		List<EventModel> models = new ArrayList<EventModel>();
		
		for(EventEntity entity: EventsEntity)
		{
			models.add( mapper.map(entity, EventModel.class) );
		}
		
		return models;
	}

	@Override
	public List<EventModel> search(Long searchTerm) {
		return null;
	}

	@Override
	public long addNew(EventModel e) {
		EventEntity entity = mapper.map(e, EventEntity.class);
		entity.setEventID(null);
		EventEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getEventID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public EventModel updateByID(EventModel e, long id) {
		EventEntity entity = mapper.map(e, EventEntity.class);
		EventEntity result = repository.save(entity);
		EventModel model = mapper.map(result, EventModel.class);
		return model;
	}

	@Override
	public Optional<EventModel> getByUniqueValue(Long value) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
