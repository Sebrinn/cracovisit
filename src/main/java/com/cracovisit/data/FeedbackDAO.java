package com.cracovisit.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cracovisit.models.FeedbackModel;
import com.cracovisit.models.UserEntity;
import com.cracovisit.models.FeedbackEntity;

public class FeedbackDAO implements DataAccessInterface<FeedbackModel, Long>{
	
	@Autowired
	FeedbackRepositoryInterface repository;
	
	@Autowired
	UserRepositoryInterface userRepo;
	
	private JdbcTemplate jdbcTemplate;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public FeedbackDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public FeedbackModel getByID(long id) {
		
		FeedbackEntity entity = repository.findById(id).orElse(null);
		
		FeedbackModel model = mapper.map(entity, FeedbackModel.class);
		
		Optional<UserEntity> userEntity = userRepo.findById(model.getUserID());
		if(userEntity.isPresent())
		{
			model.setAuthor(userEntity.get().getUserName() + " " + userEntity.get().getUserLastName());
		}
		
		
		return model;
	}

	@Override
	public List<FeedbackModel> getAll() {
		
		Iterable<FeedbackEntity> feedbacksEntity = repository.findAll();
		
		List<FeedbackModel> models = new ArrayList<FeedbackModel>();
		for(FeedbackEntity entity: feedbacksEntity)
		{
			FeedbackModel model = mapper.map(entity, FeedbackModel.class);
			Optional<UserEntity> userEntity = userRepo.findById(model.getUserID());
			if(userEntity.isPresent())
			{
				model.setAuthor(userEntity.get().getUserName() + " " + userEntity.get().getUserLastName());
			}
			else {
				model.setAuthor("Anonim");
			}
			
			models.add( model );
		}
		
		return models;
	}

	@Override
	public List<FeedbackModel> search(Long searchTerm) {
		
		Iterable<FeedbackEntity> feedbacksEntity = repository.findByAttractionID(searchTerm);
		
		List<FeedbackModel> models = new ArrayList<FeedbackModel>();
		
		for(FeedbackEntity entity: feedbacksEntity)
		{
			FeedbackModel model = mapper.map(entity, FeedbackModel.class);
			Optional<UserEntity> userEntity = userRepo.findById(model.getUserID());
			if(userEntity.isPresent())
			{
				model.setAuthor(userEntity.get().getUserName() + " " + userEntity.get().getUserLastName());
			}
			else {
				model.setAuthor("Anonim");
			}
			models.add( model );
		}
		
		return models;
	}

	@Override
	public long addNew(FeedbackModel e) {
		FeedbackEntity entity = mapper.map(e, FeedbackEntity.class);
		entity.setFeedbackID(null);
		FeedbackEntity result = repository.save(entity);
		
		if(result == null) return -1;
		return result.getAttractionID();
	}

	@Override
	public boolean deleteByID(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public FeedbackModel updateByID(FeedbackModel e, long id) {
		FeedbackEntity entity = mapper.map(e, FeedbackEntity.class);
		FeedbackEntity result = repository.save(entity);
		FeedbackModel model = mapper.map(result, FeedbackModel.class);
		return model;
	}

	@Override
	public Optional<FeedbackModel> getByUniqueValue(Long value) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
