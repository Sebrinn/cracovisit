package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.UserEntity;
import com.cracovisit.models.UserModel;

public class UserDAO implements DataAccessInterface<UserModel, String>{

	@Autowired
	UserRepositoryInterface repository;

	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public UserDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public Optional<UserModel> getByUniqueValue(String email)
	{
		UserEntity entity = repository.findByUserEmail(email).orElse(null);
		
		UserModel model = mapper.map(entity, UserModel.class);
		
		return Optional.ofNullable(model);
	}
	
	@Override
	public UserModel getByID(long id) {
		
		UserEntity entity = repository.findById(id).orElse(null);
		
		UserModel model = mapper.map(entity, UserModel.class);
		
		return model;
	}

	@Override
	public List<UserModel> getAll() {
		
		Iterable<UserEntity> loginsEntity = repository.findAll();
		
		List<UserModel> models = new ArrayList<UserModel>();
		
		for(UserEntity entity: loginsEntity)
		{
			models.add( mapper.map(entity, UserModel.class) );
		}
		
		return models;
	}

	@Override
	public List<UserModel> search(String userName) {
		
		Iterable<UserEntity> loginsEntity = repository.findByUserNameContainingIgnoreCase(userName);
		
		List<UserModel> models = new ArrayList<UserModel>();
		
		for(UserEntity entity: loginsEntity)
		{
			models.add( mapper.map(entity, UserModel.class) );
		}
		
		return models;
	}

	@Override
	public long addNew(UserModel e) {
		
		UserEntity entity = mapper.map(e, UserEntity.class);
		entity.setUserID(null);
		UserEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getUserID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public UserModel updateByID(UserModel e, long id) {
		UserEntity entity = mapper.map(e, UserEntity.class);
		UserEntity result = repository.save(entity);
		UserModel model = mapper.map(entity, UserModel.class);
		return model;
	}

}
