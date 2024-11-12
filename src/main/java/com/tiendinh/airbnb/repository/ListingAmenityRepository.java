package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.ListingAmenity;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingAmenityRepository extends JpaRepository<ListingAmenity, ListingAmenity.ListingAmenityId> {
}
