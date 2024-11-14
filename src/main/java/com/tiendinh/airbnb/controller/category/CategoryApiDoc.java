package com.tiendinh.airbnb.controller.category;

import com.tiendinh.airbnb.controller.category.request.CategoryAddRequest;
import com.tiendinh.airbnb.controller.category.request.CategoryUpdateRequest;
import com.tiendinh.airbnb.core.response.DataListResponse;
import com.tiendinh.airbnb.model.constant.ApiPath;
import com.tiendinh.airbnb.model.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;

@RequestMapping(ApiPath.CATEGORIES)
@Tag(name = "Categories", description = "Operations related to categories")
public interface CategoryApiDoc {

    @Operation(
            summary = "Get List of Categories",
            description = "Retrieve a list of categories with optional filtering by name and pagination.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the list of categories",
                            content = @Content(
                                    schema = @Schema(implementation = DataListResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters")
            }
    )
    @GetMapping
    default ResponseEntity<DataListResponse<CategoryDTO>> getCategories(
                                                                      @RequestParam(required = false) String name,
                                                                      @RequestParam(required = false, defaultValue = PAGE_SIZE) int size,
                                                                      @RequestParam(required = false, defaultValue = PAGE_DEFAULT) int page,
                                                                      @RequestParam(required = false, defaultValue = SORT_DEFAULT) String sortBy,
                                                                      @RequestParam(required = false, defaultValue = SORT_DIRECTION_DEFAULT) Sort.Direction sortDirection) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Get Category by ID",
            description = "Retrieve a single category by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the category",
                            content = @Content(
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Category not found")
            }
    )
    @GetMapping(ApiPath.BY_ID)
    default ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Create a New Category",
            description = "Create a new category by providing required details.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created the category",
                            content = @Content(
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid category data")
            }
    )
    @PostMapping
    default ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryAddRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @Operation(
            summary = "Update Category",
            description = "Update an existing category by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the category",
                            content = @Content(
                                    schema = @Schema(implementation = CategoryDTO.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Category not found"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid category data")
            }
    )
    @PutMapping(ApiPath.BY_ID)
    default ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            summary = "Delete Category",
            description = "Delete an existing category by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the category"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Category not found")
            }
    )
    @DeleteMapping(ApiPath.BY_ID)
    default ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
