package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.Property;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.utils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        Property pe = propertyRepository.save(PropertyUtils.convertDtoToEntity(dto));
        return PropertyUtils.convertEntityToDto(pe);
    }

    @Override
    public PropertyDTO getById(Long id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        return optionalProperty.map(PropertyUtils::convertEntityToDto).orElse(new PropertyDTO());
    }

    @Override
    public List<PropertyDTO> getAll() {
        List<Property> propertyList = (List<Property>) propertyRepository.findAll();
        return propertyList.stream().map(PropertyUtils::convertEntityToDto).toList();
    }

    @Override
    public PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);

        if (optionalProperty.isPresent()) {
            Property pe = optionalProperty.get();
            pe.setId(propertyDTO.getId());
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            propertyRepository.save(pe);

            return propertyDTO;
        }

        return new PropertyDTO();
    }

    @Override
    public PropertyDTO updatePropertyDescription(Long id, String description) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);

        if (optionalProperty.isPresent()) {
            Property pe = optionalProperty.get();
            pe.setDescription(description);
            propertyRepository.save(pe);
            return PropertyUtils.convertEntityToDto(pe);
        }

        return new PropertyDTO();
    }

    @Override
    public void deletePropertyById(Long id) {
        propertyRepository.findById(id).ifPresent(propertyRepository::delete);
    }

}
