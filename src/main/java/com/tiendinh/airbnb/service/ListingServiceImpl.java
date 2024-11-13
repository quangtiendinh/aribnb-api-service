package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingRequest;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public Page<ListingDTO> getAll(ListingRequest request) {
        return null;
    }
}
