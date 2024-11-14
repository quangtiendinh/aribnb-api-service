package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import com.tiendinh.airbnb.model.entity.PropertyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyTypeMapper {
    PropertyTypeDTO toDTO(PropertyType category);
}
