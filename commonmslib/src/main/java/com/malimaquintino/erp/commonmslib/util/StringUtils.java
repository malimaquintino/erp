package com.malimaquintino.erp.commonmslib.util;

public class StringUtils {
    public static String onlyNumbers(String value) {
        return value.replaceAll("[^0-9]", "");
    }
}
