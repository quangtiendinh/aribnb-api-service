package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingAddRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingUpdateRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingViewRequest;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDetailDTO;
import org.springframework.data.domain.Page;

public interface ListingService {
    Page<ListingViewDTO> getListings(ListingViewRequest request);
    ListingViewDetailDTO getListingDetail(Long id);
    ListingDTO createListing(ListingAddRequest request);
    ListingDTO updateListing(Long id, ListingUpdateRequest request);
    void deleteListing(Long id);
}
