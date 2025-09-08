package com.proyecto.consultorio_dental_backend.exception;

public class MedicoNoEncontradoException extends RuntimeException {
    public MedicoNoEncontradoException(Integer medicoId) {
        super("No se encontró ningún médico con id=" + medicoId );
    }
}
