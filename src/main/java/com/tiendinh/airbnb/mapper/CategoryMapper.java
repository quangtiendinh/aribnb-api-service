package com.tiendinh.airbnb.mapper;

import com.tiendinh.airbnb.model.dto.CategoryDTO;
import com.tiendinh.airbnb.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
}
