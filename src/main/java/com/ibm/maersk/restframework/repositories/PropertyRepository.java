package com.ibm.maersk.restframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibm.maersk.restframework.domain.Property;

@RepositoryRestResource
public interface PropertyRepository extends CrudRepository<Property, Integer>{
}
