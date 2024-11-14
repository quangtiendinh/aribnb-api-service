package com.tiendinh.airbnb.controller.propertytype;

import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeAddRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;

@RequestMapping(ApiPath.PROPERTY_TYPES)
public interface PropertyTypeApiDoc {

    @Operation(summary = "Property types item", operationId = "getListings", description = "Return the list of listings item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "200")})
    @GetMapping
    default ResponseEntity<DataListResponse<PropertyTypeDTO>> getPropertyTypes(
                                                                      @RequestParam(required = false) String name,
                                                                      @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                      @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                      @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                      @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<PropertyTypeDTO> getPropertyTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping
    default ResponseEntity<PropertyTypeDTO> createPropertyType(@Valid @RequestBody PropertyTypeAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<PropertyTypeDTO> updatePropertyType(@PathVariable Long id, @Valid @RequestBody PropertyTypeUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deletePropertyType(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
