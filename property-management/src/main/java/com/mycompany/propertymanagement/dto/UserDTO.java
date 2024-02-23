package com.mycompany.propertymanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;

}
