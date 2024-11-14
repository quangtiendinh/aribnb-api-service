package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.Category;
import com.tiendinh.airbnb.model.entity.PropertyType;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
    Page<PropertyType> findByNameContainingIgnoreCase(String name, Pageable pageable);
    boolean existsByName(String name);
    @Override
    boolean existsById(Long id);
}
