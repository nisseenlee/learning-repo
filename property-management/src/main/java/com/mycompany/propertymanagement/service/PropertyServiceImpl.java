package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(dto.getTitle());
        pe.setDescription(dto.getDescription());
        pe.setAddress(dto.getAddress());
        pe.setOwnerName(dto.getOwnerName());
        pe.setOwnerEmail(dto.getOwnerEmail());
        propertyRepository.save(pe);
        return null;
    }

}
