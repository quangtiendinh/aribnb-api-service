package com.tiendinh.airbnb.controller.reservation.request;

import com.tiendinh.airbnb.core.request.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest extends PaginationRequest {
    private Long listingId;
    private Long guestId;
}
