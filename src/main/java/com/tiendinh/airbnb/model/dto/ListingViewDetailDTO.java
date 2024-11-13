package com.tiendinh.airbnb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListingViewDetailDTO {
    private Long id;
    private String title;
    private String description;
    private Integer guests;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer beds;
    private Double pricePerNight;
    private Double cleaningFee;
    private Boolean isActive;
    private String createdAt;
    private String updatedAt;
    private Long hostId;
    private String hostUsername;
    private String hostEmail;
    private Long locationId;
    private String country;
    private String city;
    private String state;
    private String address;
    private String postalCode;
    private Double latitude;
    private Double longitude;
    private Long propertyTypeId;
    private String propertyTypeName;
    private List<String> categories;
    private List<String> amenities;
    private List<PhotoDTO> photos;
}
