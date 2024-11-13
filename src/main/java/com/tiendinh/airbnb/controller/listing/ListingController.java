package com.tiendinh.airbnb.controller.listing;

import com.tiendinh.airbnb.controller.listing.request.ListingAddRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingUpdateRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingViewRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDetailDTO;
import com.tiendinh.airbnb.service.ListingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ListingController implements ListingApiDoc {

    private final ListingService listingService;
    @Override
    public ResponseEntity<DataListResponse<ListingViewDTO>> getListings(int size, int page, String sortBy, Sort.Direction sortDirection) {
        var request = ListingViewRequest.builder()
                .size(size).page(page)
                .sortBy(sortBy).sortDirection(sortDirection)
                .build();
        return ResponseEntity.ok(DataListResponse.of(listingService.getListings(request)));
    }

    @Override
    public ResponseEntity<ListingViewDetailDTO> getListing(Long id) {
        return ResponseEntity.ok(listingService.getListingDetail(id));
    }

    @Override
    public ResponseEntity<ListingDTO> createListing(ListingAddRequest request) {
        return ResponseEntity.ok(listingService.createListing(request));
    }

    @Override
    public ResponseEntity<ListingDTO> updateListing(Long id, ListingUpdateRequest request) {
        return ResponseEntity.ok(listingService.updateListing(id, request));
    }

    @Override
    public ResponseEntity<Void> deleteListing(Long id) {
        listingService.deleteListing(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
