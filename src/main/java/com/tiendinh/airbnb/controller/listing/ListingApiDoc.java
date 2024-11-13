package com.tiendinh.airbnb.controller.listing;

import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;


@RequestMapping("")
@Tag(name = "Listings", description = "The listings api")
public interface ListingApiDoc {

    @Operation(summary = "Listings item", operationId = "getListings", description = "Return the list of listings item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "200")})
    @GetMapping
    default ResponseEntity<DataListResponse<ListingDTO>> getListings(@RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                     @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                     @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                     @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
