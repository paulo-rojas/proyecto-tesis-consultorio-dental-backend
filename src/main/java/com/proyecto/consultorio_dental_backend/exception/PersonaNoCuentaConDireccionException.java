package com.proyecto.consultorio_dental_backend.exception;

public class PersonaNoCuentaConDireccionException extends RuntimeException {
    public PersonaNoCuentaConDireccionException(Integer personaId) {
        super("El usuario con id = " + personaId + " no tiene dirección");
    }
}
