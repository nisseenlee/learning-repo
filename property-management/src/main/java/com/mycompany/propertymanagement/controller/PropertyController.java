package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Value("${spring.datasource.url:}") // ':' indicates that if the property is not found, show no error
    private String datasourceUrl;

    @Autowired
    private PropertyService propertyService;

    // http://localhost:8080/api/v1/properties/hello
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/datasource-url")
    public String showDatasourceUrl() {
        return datasourceUrl;
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

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id) {
        PropertyDTO dto = propertyService.getById(id);
        return new ResponseEntity<>(dto, dto.getId() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.updateProperty(id, propertyDTO), HttpStatus.OK);
    }

    @PatchMapping("/{id}/desc")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.updatePropertyDescription(id, propertyDTO.getDescription()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deletePropertyById(id);
    }
}
