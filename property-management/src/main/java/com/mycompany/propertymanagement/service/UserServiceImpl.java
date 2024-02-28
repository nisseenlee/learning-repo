package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.User;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (userOptional.isPresent()) {
            throw new BusinessException(List.of(
                    new ErrorModel("INVALID_REGISTER", "Email already exists")
            ));
        }

        return UserUtils.convertEntityToDto(userRepository.save(UserUtils.convertDtoToEntity(userDTO)));
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<User> userOptional = userRepository.findByOwnerEmailAndPassword(email, password);
        return userOptional.map(UserUtils::convertEntityToDto).orElseThrow(() ->
                new BusinessException(List.of(
                        new ErrorModel("INVALID_LOGIN", "Incorrect email or password")
                ))
        );
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
