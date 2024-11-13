package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.reservation.request.ReservationAddRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationUpdateRequest;
import com.tiendinh.airbnb.model.dto.ReservationDTO;
import org.springframework.data.domain.Page;

public interface ReservationService {
    Page<ReservationDTO> getReservations(ReservationRequest request);
    ReservationDTO createReservation(ReservationAddRequest request);
    ReservationDTO getReservationById(Long id);
    ReservationDTO updateReservation(Long id, ReservationUpdateRequest request);
    ReservationDTO confirmReservation(Long id);
    ReservationDTO cancelReservation(Long id);
    void deleteReservation(Long id);
}
