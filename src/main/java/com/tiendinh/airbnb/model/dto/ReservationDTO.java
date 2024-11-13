package com.tiendinh.airbnb.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiendinh.airbnb.model.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReservationDTO extends BaseDTO {
    private Long id;
    private Long listingId;
    private String listingTitle;
    private String hostName;
    private String hostEmail;
    private String hostPhoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkIn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkOut;
    private int guestsCount;
    private BigDecimal totalPrice;
    private ReservationStatus status;
}

