package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.MonumentModel;
import com.cracovisit.models.MonumentEntity;

public class MonumentDAO implements DataAccessInterface<MonumentModel, Long>{
	
	@Autowired
	MonumentRepositoryInterface repository;
	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public MonumentDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public MonumentModel getByID(long id) {
		
		MonumentEntity entity = repository.findById(id).orElse(null);
		
		MonumentModel model = mapper.map(entity, MonumentModel.class);
		
		return model;
	}

	@Override
	public List<MonumentModel> getAll() {
		
		Iterable<MonumentEntity> monumentsEntity = repository.findAll();
		
		List<MonumentModel> models = new ArrayList<MonumentModel>();
		
		for(MonumentEntity entity: monumentsEntity)
		{
			models.add( mapper.map(entity, MonumentModel.class) );
		}
		
		return models;
	}

	@Override
	public List<MonumentModel> search(Long searchTerm) {
		return null;
	}

	@Override
	public long addNew(MonumentModel e) {
		MonumentEntity entity = mapper.map(e, MonumentEntity.class);
		entity.setMonumentID(null);
		MonumentEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getMonumentID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public MonumentModel updateByID(MonumentModel e, long id) {
		MonumentEntity entity = mapper.map(e, MonumentEntity.class);
		MonumentEntity result = repository.save(entity);
		MonumentModel model = mapper.map(result, MonumentModel.class);
		return model;
	}

	@Override
	public Optional<MonumentModel> getByUniqueValue(Long value) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
