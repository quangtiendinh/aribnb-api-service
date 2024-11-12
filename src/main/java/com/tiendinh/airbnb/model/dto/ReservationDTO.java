package com.tiendinh.airbnb.model.dto;

import com.tiendinh.airbnb.model.entity.Listing;
import com.tiendinh.airbnb.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO extends BaseDTO {
    private Long id;
    private Listing listing;
    private User guest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int guestsCount;
    private BigDecimal totalPrice;
    private String status;
}

