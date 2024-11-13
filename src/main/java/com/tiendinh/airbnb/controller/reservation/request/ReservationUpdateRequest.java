package com.tiendinh.airbnb.controller.reservation.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationUpdateRequest {
    private Long listingId;
    @NotNull
    private Date checkIn;
    @NotNull
    private Date checkOut;
    private int guestsCount;
}
