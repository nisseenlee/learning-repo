package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.Property;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.utils.PropertyUtils;
import com.mycompany.propertymanagement.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.propertymanagement.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        Optional<User> userOptional = userRepository.findById(dto.getUserId());
        return userOptional.map(u -> {
            Property pe = PropertyUtils.convertDtoToEntity(dto);
            pe.setUser(u);
            pe = propertyRepository.save(pe);
            return PropertyUtils.convertEntityToDto(pe);
        }).orElseThrow(() ->
            new BusinessException(List.of(
                    new ErrorModel("USER_NOT_EXISTS", "User does not exists")
            ))
        );
    }

    @Override
    public PropertyDTO getById(Long id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        return optionalProperty.map(PropertyUtils::convertEntityToDto).orElse(new PropertyDTO());
    }

    @Override
    public List<PropertyDTO> getAllByUser(Long userId) {
        List<Property> propertyList = propertyRepository.findAllByUserId(userId);
        return propertyList.stream().map(PropertyUtils::convertEntityToDto).toList();
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
