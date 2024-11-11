package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Booking;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
}
