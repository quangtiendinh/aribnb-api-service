package com.tiendinh.airbnb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListingAmenityDTO extends BaseDTO {
    private ListingAmenityId id;
    @Getter
    @Setter
    public static class ListingAmenityId implements Serializable {
        private Long listingId;
        private Long amenityId;
    }
}
