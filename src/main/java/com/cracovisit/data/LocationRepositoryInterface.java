package com.cracovisit.data;

import org.springframework.data.repository.CrudRepository;

import com.cracovisit.models.LocationEntity;

public interface LocationRepositoryInterface extends CrudRepository<LocationEntity, Long> {

}
