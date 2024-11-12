package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Amenity;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
