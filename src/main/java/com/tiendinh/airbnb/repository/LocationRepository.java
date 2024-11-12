package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Location;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
