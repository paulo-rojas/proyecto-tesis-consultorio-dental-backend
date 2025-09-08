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

    @ExceptionHandler(ProvinciaNoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handleProvinciaNoEncontrada(ProvinciaNoEncontradaException ex) {
        Map<String, Object> response = responseMap("Provincia no encontrada", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DistritoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>>handleDistritoNoEncontrado(DistritoNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Distrito no encontrada", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PersonaNoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handlePersonaNoEncontrado(PersonaNoEncontradaException ex) {
        Map<String, Object> response = responseMap("Usuario no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PersonaYaCuentaConDireccionException.class)
    public ResponseEntity<Map<String, Object>> handlePersonaConDireccion(PersonaYaCuentaConDireccionException ex) {
        Map<String, Object> response = responseMap("Direccion ya registrada", ex.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PersonaNoCuentaConDireccionException.class)
    public ResponseEntity<Map<String, Object>> handlePersonaSinDireccion(PersonaNoCuentaConDireccionException ex) {
        Map<String, Object> response = responseMap("Sin dirección registrada", ex.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
