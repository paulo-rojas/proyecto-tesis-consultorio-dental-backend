package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.exception.DepartamentoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.DistritoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(DepartamentoNoEncontradoException.class)
    public ResponseEntity<String> handleDepartamentoNoEncontrado(DepartamentoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DistritoNoEncontradoException.class)
    public ResponseEntity<String> handleDistritoNoEncontrado(DistritoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
