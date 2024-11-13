package com.tiendinh.airbnb.service;

import com.tiendinh.airbnb.controller.category.request.CategoryAddRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryUpdateRequest;
import com.tiendinh.airbnb.exception.BusinessLogicException;
import com.tiendinh.airbnb.mapper.CategoryMapper;
import com.tiendinh.airbnb.model.constant.Constant;
import com.tiendinh.airbnb.model.dto.CategoryDTO;
import com.tiendinh.airbnb.model.entity.Category;
import com.tiendinh.airbnb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Page<CategoryDTO> getCategories(CategoryRequest request) {
        var pageable = request.getPageRequest();
        Page<Category> categoryPage;
        if (StringUtils.hasText(request.getName())) {
            categoryPage = categoryRepository.findByNameContainingIgnoreCase(request.getName(), pageable);
        } else {
            categoryPage = categoryRepository.findAll(pageable);
        }
        if (CollectionUtils.isEmpty(categoryPage.getContent())) {
            return Page.empty(pageable);
        }
        return categoryPage.map(categoryMapper::toDTO);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> BusinessLogicException.resourceNotFound("Data not found."));
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryAddRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw BusinessLogicException.resourceDuplicated("The category is already exists.");
        }
        var category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        category.setCreatedBy(Constant.SYSTEM_ADMIN);
        category.setUpdatedBy(Constant.SYSTEM_ADMIN);
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryUpdateRequest request) {
        if (!categoryRepository.existsById(id)) {
            throw BusinessLogicException.resourceNotFound("Data not found.");
        }
        var category = new Category();
        category.setId(id);
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
