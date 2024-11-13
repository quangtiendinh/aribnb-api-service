package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Reservation;
import com.tiendinh.airbnb.model.enums.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Page<Reservation> findByGuestId(Long guestId, Pageable pageable);
    Page<Reservation> findByListingId(Long listingId,  Pageable pageable);
    List<Reservation> findByStatus(ReservationStatus status);

    @Query("SELECT r FROM Reservation r WHERE r.listing.id = :listingId AND " +
            "((r.checkIn <= :checkOut AND r.checkOut >= :checkIn))")
    List<Reservation> findOverlappingReservations(@Param("listingId") Long listingId,
                                                  @Param("checkIn") Date checkIn,
                                                  @Param("checkOut") Date checkOut);
}

