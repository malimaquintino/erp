package com.malimaquintino.erp.commonmslib.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String onlyNumbers(String value) {
        return value.replaceAll("[^0-9]", "");
    }

    public static String stripAccents(String input) {
        if (input == null) {
            return null;
        } else {
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            StringBuilder decomposed = new StringBuilder(Normalizer.normalize(input, Normalizer.Form.NFD));
            convertRemainingAccentCharacters(decomposed);
            return pattern.matcher(decomposed).replaceAll("");
        }
    }

    private static void convertRemainingAccentCharacters(StringBuilder decomposed) {
        for (int i = 0; i < decomposed.length(); ++i) {
            if (decomposed.charAt(i) == 321) {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'L');
            } else if (decomposed.charAt(i) == 322) {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'l');
            }
        }

    }
}
