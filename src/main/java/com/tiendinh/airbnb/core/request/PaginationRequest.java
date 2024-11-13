package com.tiendinh.airbnb.core.request;

import com.tiendinh.airbnb.utils.PageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static com.tiendinh.airbnb.model.constant.Constant.PAGE_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.PAGE_SIZE;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DEFAULT;
import static com.tiendinh.airbnb.model.constant.Constant.SORT_DIRECTION_DEFAULT;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PaginationRequest {

    private int size;

    private int page;

    private String sortBy;

    private Sort.Direction sortDirection;

    private PageRequest pageRequest;

    public PageRequest getPageRequest() {
        size = size == 0 ? Integer.parseInt(PAGE_SIZE) : size;
        page = page == 0 ? Integer.parseInt(PAGE_DEFAULT) : page;
        sortBy = StringUtils.hasText(sortBy) ? sortBy : SORT_DEFAULT;
        sortDirection = Objects.nonNull(sortDirection) ? sortDirection : Sort.Direction.valueOf(SORT_DIRECTION_DEFAULT);
        return PageUtils.getPageRequest(page, size, sortBy, sortDirection);
    }

}
