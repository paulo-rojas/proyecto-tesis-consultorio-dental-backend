package com.proyecto.consultorio_dental_backend.exception;

public class ProvinciaNoEncontradaException extends RuntimeException {
    public ProvinciaNoEncontradaException(Integer provinciaId) {
        super("No existe provincia con id = " + provinciaId);
    }
}
