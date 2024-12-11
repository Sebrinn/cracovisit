package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.AttractionEntity;
import com.cracovisit.models.AttractionModel;

public class AttractionDAO implements DataAccessInterface<AttractionModel, String> {

	@Autowired
	AttractionRepositoryInterface repository;
	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public AttractionDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public AttractionModel getByID(long id) {
		
		AttractionEntity entity = repository.findById(id).orElse(null);
		
		AttractionModel model = mapper.map(entity, AttractionModel.class);
		
		return model;
	}

	@Override
	public List<AttractionModel> getAll() {
		
		Iterable<AttractionEntity> attractionsEntity = repository.findAll();
		
		List<AttractionModel> models = new ArrayList<AttractionModel>();
		
		for(AttractionEntity entity: attractionsEntity)
		{
			models.add( mapper.map(entity, AttractionModel.class) );
		}
		
		return models;
	}

	@Override
	public List<AttractionModel> search(String searchTerm) {
		
		Iterable<AttractionEntity> attractionsEntity = repository.findByAttractionNameContainingIgnoreCase(searchTerm);
		
		List<AttractionModel> models = new ArrayList<AttractionModel>();
		
		for(AttractionEntity entity: attractionsEntity)
		{
			models.add( mapper.map(entity, AttractionModel.class) );
		}
		
		return models;
	}

	@Override
	public long addNew(AttractionModel e) {
		
		AttractionEntity entity = mapper.map(e, AttractionEntity.class);
		entity.setAttractionID(null);
		AttractionEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getAttractionID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public AttractionModel updateByID(AttractionModel e, long id) {
		
		AttractionEntity entity = mapper.map(e, AttractionEntity.class);
		AttractionEntity result = repository.save(entity);
		AttractionModel model = mapper.map(entity, AttractionModel.class);
		return model;
	}

	@Override
	public Optional<AttractionModel> getByUniqueValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}



}
