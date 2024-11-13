package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.ListingDTO;
import com.tiendinh.airbnb.model.entity.Listing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListingMapper {
    ListingDTO toDTO(Listing entity);
}
