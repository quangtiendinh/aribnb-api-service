package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.ListingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingViewRepository extends JpaRepository<ListingView, Long> {
}
