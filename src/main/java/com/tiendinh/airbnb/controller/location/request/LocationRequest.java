package com.tiendinh.airbnb.controller.location.request;

import com.tiendinh.airbnb.core.request.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest extends PaginationRequest {
    private String country;
}
