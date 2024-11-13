package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.ReservationDTO;
import com.tiendinh.airbnb.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(source = "listing.id", target = "listingId")
    @Mapping(source = "listing.title", target = "listingTitle")
    @Mapping(source = "guest.username", target = "hostName")
    @Mapping(source = "guest.email", target = "hostEmail")
    @Mapping(source = "guest.phoneNumber", target = "hostPhoneNumber")
    ReservationDTO toDTO(Reservation reservation);
}
