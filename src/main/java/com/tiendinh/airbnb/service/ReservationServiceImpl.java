package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.reservation.request.ReservationAddRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationRequest;
import com.tiendinh.airbnb.controller.reservation.request.ReservationUpdateRequest;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.exception.ReservationException;
import com.tiendinh.airbnb.mapper.ReservationMapper;
import com.tiendinh.airbnb.model.constant.Constant;
import com.tiendinh.airbnb.model.dto.ReservationDTO;
import com.tiendinh.airbnb.model.entity.Reservation;
import com.tiendinh.airbnb.model.enums.ReservationStatus;
import com.tiendinh.airbnb.repository.ListingRepository;
import com.tiendinh.airbnb.repository.ReservationRepository;
import com.tiendinh.airbnb.repository.UserRepository;
import com.tiendinh.airbnb.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ListingRepository listingRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public Page<ReservationDTO> getReservations(ReservationRequest request) {
        var pageable = request.getPageRequest();
        Page<Reservation> reservationPage;
        if (Objects.nonNull(request.getGuestId())) {
            reservationPage = reservationRepository.findByGuestId(request.getGuestId(), pageable);
        } else if (Objects.nonNull(request.getListingId())) {
            reservationPage = reservationRepository.findByListingId(request.getListingId(), pageable);
        } else {
            reservationPage = reservationRepository.findAll(pageable);
        }
        if (CollectionUtils.isEmpty(reservationPage.getContent())) {
            return Page.empty(pageable);
        }
        return reservationPage.map(reservationMapper::toDTO);
    }

    @Override
    @Transactional
    public ReservationDTO createReservation(ReservationAddRequest request) {
        var listing = listingRepository.findById(request.getListingId())
                .orElseThrow(() -> BusinessLogicException.resourceNotFound(String.format("The reservation with listing id %d is not found.", request.getListingId())));

        var guest = userRepository.findById(request.getGuestId())
                .orElseThrow(() -> BusinessLogicException.resourceNotFound(String.format("The Guest with id %d is not found.", request.getGuestId())));

        var overlapReservations = reservationRepository.findOverlappingReservations(request.getListingId(), request.getCheckIn(), request.getCheckOut());
        if (CollectionUtils.isEmpty(overlapReservations)) {
            long nights = DateUtils.calculateNights(request.getCheckIn(), request.getCheckOut());
            BigDecimal totalPrice = listing.getPricePerNight().multiply(BigDecimal.valueOf(nights));

            Reservation reservation = new Reservation();
            reservation.setListing(listing);
            reservation.setGuest(guest);
            reservation.setCheckIn(request.getCheckIn());
            reservation.setCheckOut(request.getCheckOut());
            reservation.setGuestsCount(request.getGuestsCount());
            reservation.setTotalPrice(totalPrice);
            reservation.setStatus(ReservationStatus.PENDING);
            reservation.setCreatedAt(new Date());
            reservation.setUpdatedAt(new Date());
            reservation.setCreatedBy(Constant.SYSTEM_ADMIN);
            reservation.setUpdatedBy(Constant.SYSTEM_ADMIN);

            return reservationMapper.toDTO(reservationRepository.save(reservation));
        }
        throw ReservationException.reservationOverlapping();

    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        var reservation = reservationRepository.findById(id).orElseThrow();
        return reservationMapper.toDTO(reservation);
    }

    @Override
    @Transactional
    public ReservationDTO updateReservation(Long id, ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> BusinessLogicException.resourceNotFound(String.format("The reservation with id %d is not found.", id)));
        var overlapReservations = reservationRepository.findOverlappingReservations(request.getListingId(), request.getCheckIn(), request.getCheckOut());
        if (CollectionUtils.isEmpty(overlapReservations)) {
            reservation.setCheckIn(request.getCheckIn());
            reservation.setCheckOut(request.getCheckOut());
            reservation.setStatus(ReservationStatus.PENDING);
        } else {
            throw ReservationException.reservationOverlapping();
        }
        return reservationMapper.toDTO(reservationRepository.save(reservation));

    }

    @Override
    public ReservationDTO confirmReservation(Long id) {
        return updateReservationStatus(id, ReservationStatus.CONFIRMED);
    }

    @Override
    public ReservationDTO cancelReservation(Long id) {
        return updateReservationStatus(id, ReservationStatus.CANCELLED);
    }

    @Override
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw BusinessLogicException.resourceNotFound(String.format("The reservation with id %d is not found.", id));
        }
        reservationRepository.deleteById(id);
    }

    private ReservationDTO updateReservationStatus(Long id, ReservationStatus status) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> BusinessLogicException.resourceNotFound(String.format("The reservation with id %d is not found.", id)));

        if (reservation.getStatus() == ReservationStatus.CONFIRMED) {
            throw ReservationException.reservationConfirmed();
        }

        if (reservation.getStatus() == ReservationStatus.CANCELLED) {
            throw ReservationException.reservationCanceled();
        }
        reservation.setStatus(status);
        reservation.setUpdatedAt(new Date());
        return reservationMapper.toDTO(reservationRepository.save(reservation));
    }
}

