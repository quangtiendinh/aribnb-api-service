package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingAddRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingUpdateRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingViewRequest;
import com.tiendinh.airbnb.mapper.ListingMapper;
import com.tiendinh.airbnb.mapper.ListingViewDetailMapper;
import com.tiendinh.airbnb.mapper.ListingViewMapper;
import com.tiendinh.airbnb.model.constant.Constant;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDetailDTO;
import com.tiendinh.airbnb.model.entity.Listing;
import com.tiendinh.airbnb.model.entity.ListingCategory;
import com.tiendinh.airbnb.model.entity.Location;
import com.tiendinh.airbnb.model.entity.PropertyType;
import com.tiendinh.airbnb.model.entity.User;
import com.tiendinh.airbnb.repository.AmenityRepository;
import com.tiendinh.airbnb.repository.CategoryRepository;
import com.tiendinh.airbnb.repository.ListingRepository;
import com.tiendinh.airbnb.repository.ListingViewDetailRepository;
import com.tiendinh.airbnb.repository.ListingViewRepository;
import com.tiendinh.airbnb.repository.LocationRepository;
import com.tiendinh.airbnb.repository.PropertyTypeRepository;
import com.tiendinh.airbnb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {
    private final ListingViewRepository listingViewRepository;
    private final ListingViewDetailRepository viewDetailRepository;
    private final ListingRepository listingRepository;
    private final UserRepository userRepository;
    private final PropertyTypeRepository propertyTypeRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final AmenityRepository amenityRepository;
    private final ListingViewMapper listingViewMapper;
    private final ListingMapper listingMapper;
    private final ListingViewDetailMapper viewDetailMapper;

    @Override
    public Page<ListingViewDTO> getListings(ListingViewRequest request) {
        var pageable = request.getPageRequest();
        var listingsView = listingViewRepository.findAll(pageable);
        if (CollectionUtils.isEmpty(listingsView.getContent())) {
            return Page.empty(pageable);
        }
        return listingsView.map(listingViewMapper::toDTO);
    }

    @Override
    public ListingViewDetailDTO getListingDetail(Long id) {
        var listing = viewDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("hello"));
        return viewDetailMapper.toDTO(listing);
    }

    @Override
    @Transactional
    public ListingDTO createListing(ListingAddRequest request) {
        Optional<User> host = userRepository.findById(request.getHostId());
        Optional<PropertyType> propertyType = propertyTypeRepository.findById(request.getPropertyTypeId());
        Optional<Location> location = locationRepository.findById(request.getLocationId());
        var categories = categoryRepository.findAllById(request.getCategoryIds());

        if (host.isPresent() && propertyType.isPresent() && location.isPresent()) {
            Listing listing = new Listing();
            listing.setHost(host.get());
            listing.setTitle(request.getTitle());
            listing.setDescription(request.getDescription());
            listing.setPropertyType(propertyType.get());
            listing.setGuests(request.getGuests());
            listing.setBedrooms(request.getBedrooms());
            listing.setBathrooms(request.getBathrooms());
            listing.setBeds(request.getBeds());
            listing.setPricePerNight(request.getPricePerNight());
            listing.setCleaningFee(request.getCleaningFee());
            listing.setLocation(location.get());
            listing.setActive(request.isActive());
            listing.setUpdatedAt(new Date());
            listing.setCreatedAt(new Date());
            listing.setUpdatedBy(Constant.SYSTEM_ADMIN);
            listing.setCreatedBy(Constant.SYSTEM_ADMIN);
            if (!CollectionUtils.isEmpty(categories)) {
                var listingCategories = categories.stream()
                        .map(category -> {
                            ListingCategory listingCategory = new ListingCategory();
                            listingCategory.setListing(listing);
                            listingCategory.setCategory(category);
                            return listingCategory;
                        })
                        .collect(Collectors.toSet());
                listing.setListingCategories(listingCategories);
            }
            return listingMapper.toDTO(listingRepository.save(listing));
        } else {
            throw new IllegalArgumentException("Invalid input data for creating listing");
        }
    }

    @Override
    @Transactional
    public ListingDTO updateListing(Long id, ListingUpdateRequest request) {
        Optional<Listing> existingListing = listingRepository.findById(id);
        if (existingListing.isPresent()) {
            Listing listing = existingListing.get();
            Optional<User> host = userRepository.findById(request.getHostId());
            Optional<PropertyType> propertyType = propertyTypeRepository.findById(request.getPropertyTypeId());
            Optional<Location> location = locationRepository.findById(request.getLocationId());
            var categories = categoryRepository.findAllById(request.getCategoryIds());

            host.ifPresent(listing::setHost);
            propertyType.ifPresent(listing::setPropertyType);
            location.ifPresent(listing::setLocation);

            listing.setTitle(request.getTitle());
            listing.setDescription(request.getDescription());
            listing.setGuests(request.getGuests());
            listing.setBedrooms(request.getBedrooms());
            listing.setBathrooms(request.getBathrooms());
            listing.setBeds(request.getBeds());
            listing.setPricePerNight(request.getPricePerNight());
            listing.setCleaningFee(request.getCleaningFee());
            listing.setActive(request.isActive());
            listing.setUpdatedAt(new Date());
            listing.setCreatedAt(new Date());
            listing.setUpdatedBy(Constant.SYSTEM_ADMIN);
            listing.setCreatedBy(Constant.SYSTEM_ADMIN);
            if (!CollectionUtils.isEmpty(categories)) {
                var listingCategories = categories.stream()
                        .map(category -> {
                            ListingCategory listingCategory = new ListingCategory();
                            listingCategory.setListing(listing);
                            listingCategory.setCategory(category);
                            return listingCategory;
                        })
                        .collect(Collectors.toSet());
                listing.setListingCategories(listingCategories);
            }
            return listingMapper.toDTO(listingRepository.save(listing));
        } else {
            throw new IllegalArgumentException("Listing not found");
        }
    }

    @Override
    @Transactional
    public void deleteListing(Long listingId) {
        var listing = listingRepository.findById(listingId).orElseThrow(() -> new RuntimeException("Not found"));
        listingRepository.delete(listing);
    }
}
