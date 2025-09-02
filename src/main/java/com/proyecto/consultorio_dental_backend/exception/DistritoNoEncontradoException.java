package com.proyecto.consultorio_dental_backend.exception;

public class DistritoNoEncontradoException extends RuntimeException {
    public DistritoNoEncontradoException(Integer id) {
        super("No existe distrito con id + " + id);
    }
}
