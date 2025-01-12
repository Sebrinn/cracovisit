package com.cracovisit.data;


import org.springframework.data.repository.CrudRepository;


import com.cracovisit.models.FeedbackEntity;

public interface FeedbackRepositoryInterface extends CrudRepository<FeedbackEntity, Long> {
	
	Iterable<FeedbackEntity> findByAttractionID(Long searchTerm);
	

}
