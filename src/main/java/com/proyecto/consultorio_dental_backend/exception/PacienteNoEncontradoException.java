package com.proyecto.consultorio_dental_backend.exception;

public class PacienteNoEncontradoException extends RuntimeException {
    public PacienteNoEncontradoException(Integer id) {

        super("No existe paciente con id = " + id);
    }
}
