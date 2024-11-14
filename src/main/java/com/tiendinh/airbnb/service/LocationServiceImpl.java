package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.location.request.LocationAddRequest;
import com.tiendinh.airbnb.controller.location.request.LocationRequest;
import com.tiendinh.airbnb.controller.location.request.LocationUpdateRequest;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.mapper.LocationMapper;
import com.tiendinh.airbnb.model.constant.Constant;
import com.tiendinh.airbnb.model.dto.LocationDTO;
import com.tiendinh.airbnb.model.entity.Location;
import com.tiendinh.airbnb.repository.LocationRepository;
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
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;


    @Override
    public Page<LocationDTO> getLocations(LocationRequest request) {
        var pageable = request.getPageRequest();
        Page<Location> locationPage;
        if (StringUtils.hasText(request.getCountry())) {
            locationPage = locationRepository.findByCountryIgnoreCase(request.getCountry(), pageable);
        } else {
            locationPage = locationRepository.findAll(pageable);
        }
        if (CollectionUtils.isEmpty(locationPage.getContent())) {
            return Page.empty(pageable);
        }
        return locationPage.map(locationMapper::toDTO);
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        var location = locationRepository.findById(id).orElseThrow(() -> BusinessLogicException.resourceNotFound("Data not found."));
        return locationMapper.toDTO(location);
    }

    @Override
    public LocationDTO createLocation(LocationAddRequest request) {
        var location = new Location();
        location.setCountry(request.getCountry());
        location.setCity(request.getCity());
        location.setAddress(request.getAddress());
        location.setState(request.getState());
        location.setPostalCode(request.getPostalCode());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        location.setCreatedAt(new Date());
        location.setUpdatedAt(new Date());
        location.setCreatedBy(Constant.SYSTEM_ADMIN);
        location.setUpdatedBy(Constant.SYSTEM_ADMIN);
        return locationMapper.toDTO(locationRepository.save(location));
    }

    @Override
    public LocationDTO updateLocation(Long id, LocationUpdateRequest request) {
        if (!locationRepository.existsById(id)) {
            throw BusinessLogicException.resourceNotFound("Data not found.");
        }
        var location = new Location();
        location.setCountry(request.getCountry());
        location.setCity(request.getCity());
        location.setAddress(request.getAddress());
        location.setState(request.getState());
        location.setPostalCode(request.getPostalCode());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        location.setId(id);
        location.setCreatedAt(new Date());
        location.setUpdatedAt(new Date());
        return locationMapper.toDTO(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
