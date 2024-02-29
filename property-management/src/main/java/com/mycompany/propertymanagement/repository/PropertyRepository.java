package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.Property;
import com.mycompany.propertymanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, Long> {

    List<Property> findAllByUserId(Long userId);

}
