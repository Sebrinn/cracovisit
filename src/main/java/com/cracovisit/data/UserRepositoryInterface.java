package com.cracovisit.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cracovisit.models.AttractionEntity;
import com.cracovisit.models.UserEntity;

public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserName(String userName);
	List<UserEntity> findByUserNameContainingIgnoreCase(String searchTerm);
	
}
