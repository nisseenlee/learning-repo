package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
