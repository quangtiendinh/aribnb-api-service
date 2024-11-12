package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingRequest;
import com.tiendinh.airbnb.model.dto.CategoryDTO;
import com.tiendinh.airbnb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategories(ListingRequest request) {
        return null;
    }
}
