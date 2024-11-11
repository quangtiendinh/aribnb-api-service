package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Listing;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends PagingAndSortingRepository<Listing, Long> {
}
