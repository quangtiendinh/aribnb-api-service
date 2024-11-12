package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingRequest;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import org.springframework.data.domain.Page;

public interface ListingService {
    Page<ListingDTO> getAll(ListingRequest request);
}
