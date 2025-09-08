package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    Map<String, Object> responseMap (String error, String detalle, Integer status){
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("error", error);
        response.put("detalle", detalle);
        return response;
    }

    @ExceptionHandler(DepartamentoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleDepartamentoNoEncontrado(DepartamentoNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Departamento no encontrada", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DistritoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>>handleDistritoNoEncontrado(DistritoNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Distrito no encontrada", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DireccionNoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handleDireccionNoEncontrada(DireccionNoEncontradaException ex) {
        Map<String, Object> response = responseMap("Direccion no encontrada", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PacienteNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handlePacienteNoEncontrado(PacienteNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Paciente no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PacienteYaCuentaConDireccionException.class)
    public ResponseEntity<Map<String, Object>> handlePacienteNoEncontrado(PacienteYaCuentaConDireccionException ex) {
        Map<String, Object> response = responseMap("Direccion ya registrada", ex.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
