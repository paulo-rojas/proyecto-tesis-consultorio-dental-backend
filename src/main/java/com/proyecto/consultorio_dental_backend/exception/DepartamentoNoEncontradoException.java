package com.proyecto.consultorio_dental_backend.exception;

public class DepartamentoNoEncontradoException extends RuntimeException {

    public DepartamentoNoEncontradoException(Integer id){
        super(String.format("No se encontró el departamento con id %d", id));
    }
}
