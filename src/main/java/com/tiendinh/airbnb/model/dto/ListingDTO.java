package com.tiendinh.airbnb.model.dto;

import com.tiendinh.airbnb.model.entity.Location;
import com.tiendinh.airbnb.model.entity.PropertyType;
import com.tiendinh.airbnb.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ListingDTO extends BaseDTO {
    private Long id;
    private User host;
    private String title;
    private String description;
    private PropertyType propertyType;
    private int guests;
    private int bedrooms;
    private int bathrooms;
    private int beds;
    private BigDecimal pricePerNight;
    private BigDecimal cleaningFee;
    private Location location;
    private boolean isActive = true;
}

