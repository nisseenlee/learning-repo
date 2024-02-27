package com.mycompany.propertymanagement.utils;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.User;

public class UserUtils {

    public static User convertDtoToEntity(UserDTO dto) {
        User u = new User();

        u.setId(dto.getId());
        u.setOwnerName(dto.getOwnerName());
        u.setOwnerEmail(dto.getOwnerEmail());
        u.setPhone(dto.getPhone());
        u.setPassword(dto.getPassword());

        return u;
    }

    public static UserDTO convertEntityToDto(User u) {
        UserDTO dto = new UserDTO();

        dto.setId(u.getId());
        dto.setOwnerName(u.getOwnerName());
        dto.setOwnerEmail(u.getOwnerEmail());
        dto.setPhone(u.getPhone());

        return dto;
    }
}
