package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeAddRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeUpdateRequest;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.mapper.PropertyTypeMapper;
import com.tiendinh.airbnb.model.constant.Constant;
import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import com.tiendinh.airbnb.model.entity.PropertyType;
import com.tiendinh.airbnb.repository.PropertyTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;
    private final PropertyTypeMapper propertyTypeMapper;


    @Override
    public Page<PropertyTypeDTO> getPropertyTypes(PropertyTypeRequest request) {
        var pageable = request.getPageRequest();
        Page<PropertyType> propertyTypePage;
        if (StringUtils.hasText(request.getName())) {
            propertyTypePage = propertyTypeRepository.findByNameContainingIgnoreCase(request.getName(), pageable);
        } else {
            propertyTypePage = propertyTypeRepository.findAll(pageable);
        }
        if (CollectionUtils.isEmpty(propertyTypePage.getContent())) {
            return Page.empty(pageable);
        }
        return propertyTypePage.map(propertyTypeMapper::toDTO);
    }

    @Override
    public PropertyTypeDTO getPropertyTypeById(Long id) {
        var category = propertyTypeRepository.findById(id).orElseThrow(() -> BusinessLogicException.resourceNotFound("Data not found."));
        return propertyTypeMapper.toDTO(category);
    }

    @Override
    public PropertyTypeDTO createPropertyType(PropertyTypeAddRequest request) {
        if (propertyTypeRepository.existsByName(request.getName())) {
            throw BusinessLogicException.resourceDuplicated("The category is already exists.");
        }
        var category = new PropertyType();
        category.setName(request.getName());
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        category.setCreatedBy(Constant.SYSTEM_ADMIN);
        category.setUpdatedBy(Constant.SYSTEM_ADMIN);
        return propertyTypeMapper.toDTO(propertyTypeRepository.save(category));
    }

    @Override
    public PropertyTypeDTO updatePropertyType(Long id, PropertyTypeUpdateRequest request) {
        if (!propertyTypeRepository.existsById(id)) {
            throw BusinessLogicException.resourceNotFound("Data not found.");
        }
        var category = new PropertyType();
        category.setId(id);
        category.setName(request.getName());
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        category.setCreatedBy(Constant.SYSTEM_ADMIN);
        category.setUpdatedBy(Constant.SYSTEM_ADMIN);
        return propertyTypeMapper.toDTO(propertyTypeRepository.save(category));
    }

    @Override
    public void deletePropertyType(Long id) {
        propertyTypeRepository.deleteById(id);
    }
}
