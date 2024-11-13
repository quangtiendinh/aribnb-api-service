package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.ListingViewDTO;
import com.tiendinh.airbnb.model.entity.ListingView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListingViewMapper {
    ListingViewDTO toDTO(ListingView view);
}
