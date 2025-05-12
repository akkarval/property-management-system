package com.wipro.property_management.repository;

import com.wipro.property_management.entity.PropertyEntity;
import jakarta.persistence.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
