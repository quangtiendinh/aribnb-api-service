package com.tiendinh.airbnb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ListingViewDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal pricePerNight;
    private Boolean isActive;
    private Long hostId;
    private String hostUsername;
    private Long locationId;
    private String country;
    private String city;
    private String address;
    private String postalCode;
    private List<String> categories;
    private List<PhotoDTO> photos;
    private Date createdAt;
    private Date updatedAt;
}
