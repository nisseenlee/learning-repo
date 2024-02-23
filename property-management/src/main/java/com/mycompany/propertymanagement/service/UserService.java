package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String username, String password);
    List<UserDTO> getAll();
    UserDTO getById(Long id);
}
