package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.ListingViewDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingViewDetailRepository extends JpaRepository<ListingViewDetail, Long> {
}
