package com.tiendinh.airbnb.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmenityDTO extends BaseDTO {
    private Long id;
    private String name;
}

