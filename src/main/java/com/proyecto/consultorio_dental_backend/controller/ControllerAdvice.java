package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.response.ErrorResponseDTO;
import com.proyecto.consultorio_dental_backend.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({
            DepartamentoNoEncontradoException.class,
            ProvinciaNoEncontradaException.class,
            DistritoNoEncontradoException.class,
            PersonaNoEncontradaException.class,
            PersonaNoCuentaConDireccionException.class,
            PersonaNoCuentaConContactoException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                status.value(),
                "Recurso no encontrado",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }


    @ExceptionHandler(PersonaYaCuentaConDireccionException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflictException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                status.value(),
                "Conflicto de estado",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(DniInvalidoException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestDniInvalidException(RuntimeException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                status.value(),
                "DNI inválido",
                ex.getMessage()
                );
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                status.value(),
                "Error Interno del Servidor",
                "Ocurrió un error inesperado. Por favor, contacte al administrador."
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}
