package com.tiendinh.airbnb.controller.listing;

import com.tiendinh.airbnb.controller.listing.request.ListingAddRequest;
import com.tiendinh.airbnb.controller.listing.request.ListingUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDTO;
import com.tiendinh.airbnb.model.dto.ListingViewDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;


@RequestMapping(ApiPath.LISTINGS)
@Tag(name = "Listings", description = "The listings API")
public interface ListingApiDoc {

    @Operation(
            summary = "Get List of Listings",
            description = "Retrieve a list of listings with optional pagination and sorting.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of listings",
                            content = @Content(
                                    schema = @Schema(implementation = DataListResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters")
            }
    )
    @GetMapping
    default ResponseEntity<DataListResponse<ListingViewDTO>> getListings(@RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                         @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                         @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                         @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Listing by ID",
            description = "Retrieve a single listing by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the listing",
                            content = @Content(
                                    schema = @Schema(implementation = ListingViewDetailDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Listing not found")
            }
    )
    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<ListingViewDetailDTO> getListing(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Create a New Listing",
            description = "Create a new listing by providing the necessary details.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created the listing",
                            content = @Content(
                                    schema = @Schema(implementation = ListingDTO.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid listing data")
            }
    )
    @PostMapping
    default ResponseEntity<ListingDTO> createListing(@Valid @RequestBody ListingAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Listing",
            description = "Update an existing listing by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the listing",
                            content = @Content(
                                    schema = @Schema(implementation = ListingDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Listing not found"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid listing data")
            }
    )
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<ListingDTO> updateListing(@PathVariable Long id, @Valid @RequestBody ListingUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Listing",
            description = "Delete an existing listing by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the listing"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Listing not found")
            }
    )
    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
