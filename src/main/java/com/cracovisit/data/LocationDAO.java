package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.LocationEntity;
import com.cracovisit.models.LocationModel;

public class LocationDAO implements DataAccessInterface<LocationModel, Long>{
	
	@Autowired
	LocationRepositoryInterface repository;
	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public LocationDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public LocationModel getByID(long id) {
		
		LocationEntity entity = repository.findById(id).orElse(null);
		
		LocationModel model = mapper.map(entity, LocationModel.class);
		
		return model;
	}

	@Override
	public List<LocationModel> getAll() {
		
		Iterable<LocationEntity> locationsEntity = repository.findAll();
		
		List<LocationModel> models = new ArrayList<LocationModel>();
		
		for(LocationEntity entity: locationsEntity)
		{
			models.add( mapper.map(entity, LocationModel.class) );
		}
		
		return models;
	}

	@Override
	public List<LocationModel> search(Long searchTerm) {
		return null;
	}

	@Override
	public long addNew(LocationModel e) {
		LocationEntity entity = mapper.map(e, LocationEntity.class);
		entity.setlocationID(null);
		LocationEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getlocationID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public LocationModel updateByID(LocationModel e, long id) {
		LocationEntity entity = mapper.map(e, LocationEntity.class);
		LocationEntity result = repository.save(entity);
		LocationModel model = mapper.map(result, LocationModel.class);
		return model;
	}

	@Override
	public Optional<LocationModel> getByUniqueValue(Long value) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
