package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.listing.request.ListingRequest;
import com.tiendinh.airbnb.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategories(ListingRequest request);
}
