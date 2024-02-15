package com.in28minutes.rest.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty("user_name")
    private String name;


    private LocalDate birthDate;
}
