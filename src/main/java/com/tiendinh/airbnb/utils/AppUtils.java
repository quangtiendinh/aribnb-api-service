package com.tiendinh.airbnb.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppUtils {
    private AppUtils () {}

    public static long getCurrentPageResponseFE(long page) {
        return page + 1;
    }
}
