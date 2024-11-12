package com.tiendinh.airbnb.repository;

import com.tiendinh.airbnb.model.entity.PropertyType;
import com.tiendinh.airbnb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
}
