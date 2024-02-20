package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // http://localhost:8080/api/v1/properties/hello
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.saveProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyDTOList = propertyService.getAll();
        return new ResponseEntity<>(propertyDTOList, HttpStatus.OK);
    }
}
