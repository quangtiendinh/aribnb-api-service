package com.tiendinh.airbnb.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tiendinh.airbnb.model.entity.Listing;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhotoDTO extends BaseDTO {
    private Long id;
    private Listing listing;
    private String url;
    private String description;
    private boolean isCover = false;
}

