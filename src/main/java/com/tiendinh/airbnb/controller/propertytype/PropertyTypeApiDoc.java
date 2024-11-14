package com.tiendinh.airbnb.controller.propertytype;

import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeAddRequest;
import com.tiendinh.airbnb.controller.propertytype.request.PropertyTypeUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.PropertyTypeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Property Types", description = "The property types API")
public interface PropertyTypeApiDoc {

    @Operation(
            summary = "Get List of Property Types",
            description = "Retrieve a list of property types with optional filtering, pagination, and sorting.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of property types",
                            content = @Content(
                                    schema = @Schema(implementation = DataListResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters")
            }
    )
    @GetMapping
    default ResponseEntity<DataListResponse<PropertyTypeDTO>> getPropertyTypes(
                                                                      @RequestParam(required = false) String name,
                                                                      @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                      @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                      @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                      @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(
            summary = "Get Property Type by ID",
            description = "Retrieve a property type by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the property type",
                            content = @Content(
                                    schema = @Schema(implementation = PropertyTypeDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Property type not found")
            }
    )
    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<PropertyTypeDTO> getPropertyTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Create a New Property Type",
            description = "Create a new property type by providing the necessary details.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created the property type",
                            content = @Content(
                                    schema = @Schema(implementation = PropertyTypeDTO.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid property type data")
            }
    )
    @PostMapping
    default ResponseEntity<PropertyTypeDTO> createPropertyType(@Valid @RequestBody PropertyTypeAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @Operation(
            summary = "Update Property Type",
            description = "Update an existing property type by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the property type",
                            content = @Content(
                                    schema = @Schema(implementation = PropertyTypeDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Property type not found"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid property type data")
            }
    )
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<PropertyTypeDTO> updatePropertyType(@PathVariable Long id, @Valid @RequestBody PropertyTypeUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Property Type",
            description = "Delete an existing property type by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the property type"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Property type not found")
            }
    )
    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deletePropertyType(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
