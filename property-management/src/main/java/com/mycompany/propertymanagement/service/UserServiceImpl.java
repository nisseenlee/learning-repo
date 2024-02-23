package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.User;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user = UserUtils.convertDtoToEntity(userDTO);
        return UserUtils.convertEntityToDto(userRepository.save(user));
    }

    @Override
    public UserDTO login(String username, String password) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.stream().map(UserUtils::convertEntityToDto).toList();
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserUtils::convertEntityToDto).orElseGet(UserDTO::new);
    }


}
