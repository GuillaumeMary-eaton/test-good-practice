package com.eaton.hug4bugs.testgoodpractice.badcodebase.utils;

public final class DummyStringUtils {
    private DummyStringUtils() {
        // not instantiable
    }

    public static String convertToUpperCase(String stringInput) {
        return stringInput.toUpperCase();
    }
}
