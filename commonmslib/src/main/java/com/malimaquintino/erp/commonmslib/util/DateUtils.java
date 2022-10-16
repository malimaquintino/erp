package com.malimaquintino.erp.commonmslib.util;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate nowPlusDays(Integer days) {
        return LocalDate.now().plusDays(days);
    }
}
