package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeAddRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeUpdateRequest;
import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import org.springframework.data.domain.Page;

public interface PropertyTypeService {
    Page<PropertyTypeDTO> getPropertyTypes(PropertyTypeRequest request);
    PropertyTypeDTO getPropertyTypeById(Long id);
    PropertyTypeDTO createPropertyType(PropertyTypeAddRequest request);
    PropertyTypeDTO updatePropertyType(Long id, PropertyTypeUpdateRequest request);
    void deletePropertyType(Long id);
}
