package com.proyecto.consultorio_dental_backend.exception;

public class PacienteNoCuentaConDireccionException extends RuntimeException {
    public PacienteNoCuentaConDireccionException(Integer pacienteId) {
        super("El paciente con id = " + pacienteId + " no tiene dirección que borrar.");
    }
}
