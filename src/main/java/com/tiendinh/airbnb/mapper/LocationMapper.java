package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.LocationDTO;
import com.tiendinh.airbnb.model.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location category);
}
