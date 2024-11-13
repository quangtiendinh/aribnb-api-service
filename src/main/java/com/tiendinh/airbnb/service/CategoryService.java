package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.category.request.CategoryAddRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryUpdateRequest;
import com.tiendinh.airbnb.model.dto.CategoryDTO;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryDTO> getCategories(CategoryRequest request);
    CategoryDTO getCategoryById(Long id);
    CategoryDTO createCategory(CategoryAddRequest request);
    CategoryDTO updateCategory(Long id, CategoryUpdateRequest request);
    void deleteCategory(Long id);
}

