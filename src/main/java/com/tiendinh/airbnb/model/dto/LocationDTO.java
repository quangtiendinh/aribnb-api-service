package com.tiendinh.airbnb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO extends BaseDTO {
    private Long id;
    private String country;
    private String city;
    private String state;
    private String address;
    private String postalCode;
    private Double latitude;
    private Double longitude;
}
