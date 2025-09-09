package com.proyecto.consultorio_dental_backend.exception;

public class PersonaNoCuentaConContactoException extends RuntimeException {
    public PersonaNoCuentaConContactoException(Integer personaId) {
        super("El usuario con id = " + personaId);
    }
}
