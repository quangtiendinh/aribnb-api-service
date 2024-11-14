package com.tiendinh.airbnb.controller.reservation;

import com.tiendinh.airbnb.controller.reservation.request.ReservationAddRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.ReservationDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;

@RequestMapping(ApiPath.RESERVATIONS)
public interface ReservationApiDoc {

    @GetMapping
    default ResponseEntity<DataListResponse<ReservationDTO>> getReservations(@RequestParam(required = false) Long listingId,
                                                                             Long guestId,
                                                                             @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                             @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                             @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                             @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    @PostMapping
    default ResponseEntity<ReservationDTO> createReservation(@Valid @RequestBody ReservationAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}/confirm")
    default ResponseEntity<ReservationDTO> confirmReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}/cancel")
    default ResponseEntity<ReservationDTO> cancelReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
