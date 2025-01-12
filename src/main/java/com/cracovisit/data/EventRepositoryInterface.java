package com.cracovisit.data;

import org.springframework.data.repository.CrudRepository;

import com.cracovisit.models.EventEntity;

public interface EventRepositoryInterface extends CrudRepository<EventEntity, Long> {

}
