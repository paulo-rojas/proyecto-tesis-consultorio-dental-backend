package com.proyecto.consultorio_dental_backend.util;

public final class CommonUtils {

    public static boolean isValidId(Integer id) {
        return id != null && id<0;
    }

    public static boolean isValidDni(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

}
