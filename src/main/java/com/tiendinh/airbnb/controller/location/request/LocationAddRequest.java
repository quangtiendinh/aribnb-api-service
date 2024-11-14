package com.tiendinh.airbnb.controller.location.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationAddRequest {
    private String country;
    private String city;
    private String state;
    private String address;
    private String postalCode;
    private Double latitude;
    private Double longitude;
}
