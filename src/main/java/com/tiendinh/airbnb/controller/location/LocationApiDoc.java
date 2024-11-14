package com.tiendinh.airbnb.controller.location;

import com.tiendinh.airbnb.controller.location.request.LocationAddRequest;
import com.tiendinh.airbnb.controller.location.request.LocationUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.LocationDTO;
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

@RequestMapping(ApiPath.LOCATIONS)
@Tag(name = "Locations", description = "The locations API")
public interface LocationApiDoc {

    @Operation(
            summary = "Get List of Locations",
            description = "Retrieve a list of locations with optional filtering, pagination, and sorting.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of locations",
                            content = @Content(
                                    schema = @Schema(implementation = DataListResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters")
            }
    )
    @GetMapping
    default ResponseEntity<DataListResponse<LocationDTO>> getLocations(
                                                                      @RequestParam(required = false) String country,
                                                                      @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                      @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                      @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                      @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Location by ID",
            description = "Retrieve a location by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the location",
                            content = @Content(
                                    schema = @Schema(implementation = LocationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Location not found")
            }
    )
    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Create a New Location",
            description = "Create a new location by providing the necessary details.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created the location",
                            content = @Content(
                                    schema = @Schema(implementation = LocationDTO.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid location data")
            }
    )
    @PostMapping
    default ResponseEntity<LocationDTO> createLocation(@Valid @RequestBody LocationAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Location",
            description = "Update an existing location by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the location",
                            content = @Content(
                                    schema = @Schema(implementation = LocationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Location not found"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid location data")
            }
    )
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @Valid @RequestBody LocationUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Location",
            description = "Delete an existing location by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the location"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Location not found")
            }
    )
    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
