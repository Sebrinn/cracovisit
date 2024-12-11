package com.cracovisit.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cracovisit.models.AttractionEntity;

public interface AttractionRepositoryInterface extends CrudRepository<AttractionEntity, Long>{

	List<AttractionEntity> findByAttractionNameContainingIgnoreCase(String searchTerm);
	
}
