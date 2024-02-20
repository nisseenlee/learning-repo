package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
