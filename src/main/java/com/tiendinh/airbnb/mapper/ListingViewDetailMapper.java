package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.ListingViewDetailDTO;
import com.tiendinh.airbnb.model.entity.ListingViewDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListingViewDetailMapper {
    ListingViewDetailDTO toDTO(ListingViewDetail view);
}
