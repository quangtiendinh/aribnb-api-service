package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.location.request.LocationAddRequest;
import com.tiendinh.airbnb.controller.location.request.LocationRequest;
import com.tiendinh.airbnb.controller.location.request.LocationUpdateRequest;
import com.tiendinh.airbnb.model.dto.LocationDTO;
import org.springframework.data.domain.Page;

public interface LocationService {
    Page<LocationDTO> getLocations(LocationRequest request);
    LocationDTO getLocationById(Long id);
    LocationDTO createLocation(LocationAddRequest request);
    LocationDTO updateLocation(Long id, LocationUpdateRequest request);
    void deleteLocation(Long id);
}

