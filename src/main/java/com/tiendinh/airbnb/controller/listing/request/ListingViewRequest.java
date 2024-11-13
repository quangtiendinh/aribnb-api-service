package com.tiendinh.airbnb.controller.listing.request;

import com.tiendinh.airbnb.core.request.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ListingViewRequest extends PaginationRequest {
    private String name;
}
