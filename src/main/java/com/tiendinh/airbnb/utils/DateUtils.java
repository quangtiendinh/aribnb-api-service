package com.tiendinh.airbnb.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {
    private DateUtils () {}

    public static  long calculateNights(Date checkInDate, Date checkOutDate) {
        LocalDate checkInLocalDate = checkInDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOutLocalDate = checkOutDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(checkInLocalDate, checkOutLocalDate);
    }

}
