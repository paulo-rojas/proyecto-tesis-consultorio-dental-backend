package com.proyecto.consultorio_dental_backend.exception;

public class PacienteYaCuentaConDireccionException extends RuntimeException {
    public PacienteYaCuentaConDireccionException(Integer pacienteId) {
        super("El paciente con id = " + pacienteId + " ya tiene dirección registrada.");
    }
}
