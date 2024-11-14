package com.tiendinh.airbnb.controller.reservation;

import com.tiendinh.airbnb.controller.reservation.request.ReservationAddRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.ReservationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Reservations", description = "API for managing reservations")
public interface ReservationApiDoc {

    @Operation(
            summary = "Get List of Reservations",
            description = "Retrieve a list of reservations with optional filters, pagination, and sorting.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of reservations",
                            content = @Content(
                                    schema = @Schema(implementation = DataListResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters")
            }
    )
    @GetMapping
    default ResponseEntity<DataListResponse<ReservationDTO>> getReservations(@RequestParam(required = false) Long listingId,
                                                                             Long guestId,
                                                                             @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                             @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                             @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                             @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    @Operation(
            summary = "Create a New Reservation",
            description = "Create a new reservation by providing the necessary details.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created the reservation",
                            content = @Content(
                                    schema = @Schema(implementation = ReservationDTO.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid reservation data")
            }
    )
    @PostMapping
    default ResponseEntity<ReservationDTO> createReservation(@Valid @RequestBody ReservationAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Reservation by ID",
            description = "Retrieve a reservation by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the reservation",
                            content = @Content(
                                    schema = @Schema(implementation = ReservationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Reservation not found")
            }
    )
    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Update Reservation",
            description = "Update an existing reservation by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the reservation",
                            content = @Content(
                                    schema = @Schema(implementation = ReservationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Reservation not found"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid reservation data")
            }
    )
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Confirm Reservation",
            description = "Confirm a reservation by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully confirmed the reservation",
                            content = @Content(
                                    schema = @Schema(implementation = ReservationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Reservation not found")
            }
    )
    @PutMapping("/{id}/confirm")
    default ResponseEntity<ReservationDTO> confirmReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Cancel Reservation",
            description = "Cancel a reservation by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully canceled the reservation",
                            content = @Content(
                                    schema = @Schema(implementation = ReservationDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Reservation not found")
            }
    )
    @PutMapping("/{id}/cancel")
    default ResponseEntity<ReservationDTO> cancelReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Reservation",
            description = "Delete a reservation by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the reservation"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Reservation not found")
            }
    )
    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
