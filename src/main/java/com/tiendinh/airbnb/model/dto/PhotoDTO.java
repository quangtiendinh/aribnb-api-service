package com.tiendinh.airbnb.model.dto;

import com.tiendinh.airbnb.model.entity.Listing;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDTO extends BaseDTO {
    private Long id;
    private Listing listing;
    private String url;
    private String description;
    private boolean isCover = false;
}

