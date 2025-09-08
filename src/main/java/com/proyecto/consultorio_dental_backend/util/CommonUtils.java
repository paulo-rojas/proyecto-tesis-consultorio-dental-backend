package com.proyecto.consultorio_dental_backend.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public final class CommonUtils {

    public static boolean isValidId(Integer id) {
        return id != null && id>0;
    }

    public static boolean isValidDni(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public static Map<String,String> errorMessageMap(String message){
        return Map.of("Error", message);
    }

    public static int calcularEdad(LocalDate fechaNacimiento) {
        return fechaNacimiento != null ?
                Period.between(fechaNacimiento, LocalDate.now()).getYears() : 0;
    }


}
