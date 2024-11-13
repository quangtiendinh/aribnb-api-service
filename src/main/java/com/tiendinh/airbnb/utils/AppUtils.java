package com.tiendinh.airbnb.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class AppUtils {
    private AppUtils () {}

    public static long getCurrentPageResponseFE(long page) {
        return page + 1;
    }

    public static String getRequestBearerToken(HttpServletRequest request) {
        var bearerToken = request.getHeader("Authorization");
        var hasToken = hasText(bearerToken) && bearerToken.startsWith("Bearer ");
        return hasToken ? bearerToken.substring(7) : null;
    }
}
