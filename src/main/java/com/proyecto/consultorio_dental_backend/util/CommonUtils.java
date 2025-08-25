package com.proyecto.consultorio_dental_backend.util;

public final class CommonUtils {

    public static boolean isValidId(String id) {
        return id != null && !id.isEmpty() && id.matches("\\d+");
    }
}
