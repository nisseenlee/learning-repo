package com.mycompany.propertymanagement.utils;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.Property;

public class PropertyUtils {

    private PropertyUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Property convertDtoToEntity(PropertyDTO dto) {
        Property pe = new Property();

        pe.setTitle(dto.getTitle());
        pe.setDescription(dto.getDescription());
        pe.setAddress(dto.getAddress());
        pe.setPrice(dto.getPrice());

        return pe;
    }

    public static PropertyDTO convertEntityToDto(Property pe) {
        PropertyDTO dto = new PropertyDTO();

        dto.setId(pe.getId());
        dto.setTitle(pe.getTitle());
        dto.setDescription(pe.getDescription());
        dto.setAddress(pe.getAddress());
        dto.setPrice(pe.getPrice());
        dto.setUserId(pe.getUser().getId());
        dto.setOwnerName(pe.getUser().getOwnerName());
        dto.setOwnerEmail(pe.getUser().getOwnerEmail());

        return dto;
    }
}
