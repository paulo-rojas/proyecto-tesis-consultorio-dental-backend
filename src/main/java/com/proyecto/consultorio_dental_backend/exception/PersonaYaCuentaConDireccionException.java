package com.proyecto.consultorio_dental_backend.exception;

public class PersonaYaCuentaConDireccionException extends RuntimeException {
    public PersonaYaCuentaConDireccionException(Integer personaId) {
        super("El usuario con id = " + personaId + " ya tiene dirección registrada.");
    }
}
