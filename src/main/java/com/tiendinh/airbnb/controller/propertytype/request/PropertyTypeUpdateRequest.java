package com.tiendinh.airbnb.controller.propertytype.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyTypeUpdateRequest {
    @NotBlank
    private String name;
    private String description;
}
