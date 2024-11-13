package com.tiendinh.airbnb.controller.reservation.request;

import com.tiendinh.airbnb.model.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationAddRequest {
    private Long listingId;
    private Long guestId;
    private Date checkIn;
    private Date checkOut;
    private int guestsCount;
    private ReservationStatus status;
}
