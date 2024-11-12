package com.tiendinh.airbnb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO extends BaseDTO {
    private Long id;
    private String name;
    private String description;
}

