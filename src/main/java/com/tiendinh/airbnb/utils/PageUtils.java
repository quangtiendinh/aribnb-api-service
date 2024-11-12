package com.tiendinh.airbnb.utils;

import com.tiendinh.airbnb.model.constant.Constant;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtils {

    public static PageRequest getPageRequest(int page, int size, String sortBy, Sort.Direction sortDirection) {
        return PageRequest.of(page - Integer.parseInt(Constant.PAGE_DEFAULT), size, Sort.by(sortDirection, sortBy));
    }
}
