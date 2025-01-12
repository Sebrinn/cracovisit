package com.cracovisit.data;

import org.springframework.data.repository.CrudRepository;

import com.cracovisit.models.LocationEntity;
import com.cracovisit.models.MonumentEntity;

public interface MonumentRepositoryInterface extends CrudRepository<MonumentEntity, Long> {

}
