package com.tiendinh.airbnb.controller.category.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAddRequest {
    @NotBlank
    private String name;
    private String description;
}
