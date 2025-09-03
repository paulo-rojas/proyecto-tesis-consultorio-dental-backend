package com.proyecto.consultorio_dental_backend.exception;

public class DireccionNoEncontradaException extends RuntimeException {

    public DireccionNoEncontradaException(String entidad, Integer id) {
        super(String.format("La entidad %s con id %s no cuenta con dirección registrada",entidad, id));
    }
}
