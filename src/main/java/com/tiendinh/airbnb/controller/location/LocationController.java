package com.tiendinh.airbnb.controller.location;

import com.tiendinh.airbnb.controller.location.request.LocationAddRequest;
import com.tiendinh.airbnb.controller.location.request.LocationRequest;
import com.tiendinh.airbnb.controller.location.request.LocationUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.LocationDTO;
import com.tiendinh.airbnb.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LocationController implements LocationApiDoc {

    private final LocationService locationService;

    @Override
    public ResponseEntity<DataListResponse<LocationDTO>> getLocations(String country, int size,
                                                                      int page, String sortBy,
                                                                      Sort.Direction sortDirection) {
        var request = LocationRequest.builder()
                .country(country)
                .size(size).page(page)
                .sortBy(sortBy).sortDirection(sortDirection)
                .build();
        return ResponseEntity.ok(DataListResponse.of(locationService.getLocations(request)));
    }

    @Override
    public ResponseEntity<LocationDTO> getLocationById(Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @Override
    public ResponseEntity<LocationDTO> createLocation(LocationAddRequest request) {
        return ResponseEntity.ok(locationService.createLocation(request));
    }

    @Override
    public ResponseEntity<LocationDTO> updateLocation(Long id, LocationUpdateRequest request) {
        return ResponseEntity.ok(locationService.updateLocation(id, request));
    }

    @Override
    public ResponseEntity<Void> deleteLocation(Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}