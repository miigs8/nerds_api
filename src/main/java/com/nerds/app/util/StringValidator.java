package com.nerds.app.util;

public final class StringValidator {
    private StringValidator() {
        throw new UnsupportedOperationException("[ERROR] Cannot instantiate utility class");
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isAlphabetic(String str) {
        return !isBlank(str) && str.matches("^[\\p{L} -\\+]+$");
    }

    public static boolean isAlphanumeric(String str) {
        return !isBlank(str) && str.matches("^[A-Z0-9]+$");
    }
}
