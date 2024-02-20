package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.Property;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.utils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        Property pe = propertyRepository.save(PropertyUtils.convertDtoToEntity(dto));
        return PropertyUtils.convertEntityToDto(pe);
    }

    @Override
    public List<PropertyDTO> getAll() {
        List<Property> propertyList = (List<Property>) propertyRepository.findAll();
        return propertyList.stream().map(PropertyUtils::convertEntityToDto).toList();
    }

}
