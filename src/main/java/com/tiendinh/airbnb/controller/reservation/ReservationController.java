package com.tiendinh.airbnb.controller.reservation;

import com.tiendinh.airbnb.controller.reservation.request.ReservationAddRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.ReservationDTO;
import com.tiendinh.airbnb.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReservationController implements ReservationApiDoc {

    private final ReservationService reservationService;
    @Override
    public ResponseEntity<DataListResponse<ReservationDTO>> getReservations(Long listingId, Long guestId, int size, int page, String sortBy, Sort.Direction sortDirection) {
        var request = ReservationRequest.builder().listingId(listingId).guestId(guestId)
                .size(size).page(page).sortBy(sortBy).sortDirection(sortDirection)
                .build();

        return ResponseEntity.ok(DataListResponse.of(reservationService.getReservations(request)));
    }

    @Override
    public ResponseEntity<ReservationDTO> createReservation(ReservationAddRequest request) {
       return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(request));
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationById(Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @Override
    public ResponseEntity<ReservationDTO> updateReservation(Long id, ReservationUpdateRequest request) {
        return ResponseEntity.ok(reservationService.updateReservation(id, request));
    }

    @Override
    public ResponseEntity<Void> deleteReservation(Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ReservationDTO> confirmReservation(Long id) {
        return ResponseEntity.ok(reservationService.confirmReservation(id));
    }

    @Override
    public ResponseEntity<ReservationDTO> cancelReservation(Long id) {
        return ResponseEntity.ok(reservationService.cancelReservation(id));
    }
}
