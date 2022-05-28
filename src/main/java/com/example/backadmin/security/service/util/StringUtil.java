package com.example.backadmin.security.service.util;

public class StringUtil {
    public static boolean isNotEmpty(Object value) {
        return value!= null && !value.toString().isEmpty();
    }
}
