package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Email is mandatory")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 1, max = 50, message = "Email be between 1 to 50 characters")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password is mandatory")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

}
