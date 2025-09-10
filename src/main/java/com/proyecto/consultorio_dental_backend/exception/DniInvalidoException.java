package com.proyecto.consultorio_dental_backend.exception;

public class DniInvalidoException extends RuntimeException {
    public DniInvalidoException(String dni) {
        super("El dni ingresado (" + dni + ") es inválido.");
    }
}
