package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByOwnerEmailAndPassword(String email, String password);
    Optional<User> findByOwnerEmail(String email);

}
