package com.malimaquintino.erp.commonmslib.util;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate nowPlusDays(Integer days) {
        return LocalDate.now().plusDays(days);
    }

    public static LocalDate nextDateFromDay(Integer day) {
        var now = LocalDate.now();
        var date = LocalDate.of(now.getYear(), now.getMonth(), day);
        if (now.isAfter(date)) {
            date = date.plusMonths(1);
        }
        return date;
    }
}
