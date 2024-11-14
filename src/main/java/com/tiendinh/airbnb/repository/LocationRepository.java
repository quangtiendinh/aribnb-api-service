package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Page<Location> findByCountryIgnoreCase(String country, Pageable pageable);
    @Override
    boolean existsById(Long id);
}
