package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    PropertyDTO getById(Long id);
    List<PropertyDTO> getAll();
    PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO);
    PropertyDTO updatePropertyDescription(Long id, String description);
    void deletePropertyById(Long id);

}
