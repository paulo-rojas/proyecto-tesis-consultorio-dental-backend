package com.proyecto.consultorio_dental_backend.exception;

public class PersonaNoEncontradaException extends RuntimeException {
    public PersonaNoEncontradaException(Integer personaId) {
        super("No se encontró ningún usuario con id = " + personaId);
    }
}
