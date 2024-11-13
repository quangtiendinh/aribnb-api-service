package com.tiendinh.airbnb.controller.listing;

import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(ApiPath.LISTINGS)
@RequiredArgsConstructor
public class ListingController implements ListingApiDoc {

    @Override
    public ResponseEntity<DataListResponse<ListingDTO>> getListings(int size, int page, String sortBy, Sort.Direction sortDirection) {
        return ListingApiDoc.super.getListings(size, page, sortBy, sortDirection);
    }
}
