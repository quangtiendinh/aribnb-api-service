package com.tiendinh.airbnb.controller.category;

import com.tiendinh.airbnb.controller.category.request.CategoryAddRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.dto.CategoryDTO;
import com.tiendinh.airbnb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApiDoc {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<DataListResponse<CategoryDTO>> getCategories(String name, int size,
                                                                        int page, String sortBy,
                                                                       Sort.Direction sortDirection) {
        var request = CategoryRequest.builder()
                .name(name)
                .size(size).page(page)
                .sortBy(sortBy).sortDirection(sortDirection)
                .build();
        return ResponseEntity.ok(DataListResponse.of(categoryService.getCategories(request)));
    }

    @Override
    public ResponseEntity<CategoryDTO> getCategoryById(Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @Override
    public ResponseEntity<CategoryDTO> createCategory(CategoryAddRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @Override
    public ResponseEntity<CategoryDTO> updateCategory(Long id, CategoryUpdateRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}