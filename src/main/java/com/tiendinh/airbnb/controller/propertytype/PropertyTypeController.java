package com.tiendinh.airbnb.controller.propertytype;

import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeAddRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import com.tiendinh.airbnb.service.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PropertyTypeController implements PropertyTypeApiDoc {

    private final PropertyTypeService propertyTypeService;

    @Override
    public ResponseEntity<DataListResponse<PropertyTypeDTO>> getPropertyTypes(String name, int size,
                                                                              int page, String sortBy,
                                                                              Sort.Direction sortDirection) {
        var request = PropertyTypeRequest.builder()
                .name(name)
                .size(size).page(page)
                .sortBy(sortBy).sortDirection(sortDirection)
                .build();
        return ResponseEntity.ok(DataListResponse.of(propertyTypeService.getPropertyTypes(request)));
    }

    @Override
    public ResponseEntity<PropertyTypeDTO> getPropertyTypeById(Long id) {
        return ResponseEntity.ok(propertyTypeService.getPropertyTypeById(id));
    }

    @Override
    public ResponseEntity<PropertyTypeDTO> createPropertyType(PropertyTypeAddRequest request) {
        return ResponseEntity.ok(propertyTypeService.createPropertyType(request));
    }

    @Override
    public ResponseEntity<PropertyTypeDTO> updatePropertyType(Long id, PropertyTypeUpdateRequest request) {
        return ResponseEntity.ok(propertyTypeService.updatePropertyType(id, request));
    }

    @Override
    public ResponseEntity<Void> deletePropertyType(Long id) {
        propertyTypeService.deletePropertyType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}