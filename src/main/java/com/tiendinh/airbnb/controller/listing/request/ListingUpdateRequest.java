package com.tiendinh.airbnb.controller.listing.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class ListingUpdateRequest {
    @NotNull
    private Long hostId;
    private String title;
    private String description;
    private Long propertyTypeId;
    private int guests;
    private int bedrooms;
    private int bathrooms;
    private int beds;
    private BigDecimal pricePerNight;
    private BigDecimal cleaningFee;
    private Long locationId;
    private final boolean active = true;
    private Set<Long> categoryIds;
    private Set<Long> amenities;
}
