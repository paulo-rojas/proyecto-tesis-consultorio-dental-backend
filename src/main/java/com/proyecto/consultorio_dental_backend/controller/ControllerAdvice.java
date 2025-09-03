package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.exception.DepartamentoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.DireccionNoEncontradaException;
import com.proyecto.consultorio_dental_backend.exception.DistritoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.PacienteNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    Map<String, Object> responseMap (String error, String detalle){
        Map<String, Object> response = new HashMap<>();
        response.put("error", error);
        response.put("detalle", detalle);
        return response;
    }

    @ExceptionHandler(DepartamentoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleDepartamentoNoEncontrado(DepartamentoNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Departamento no encontrada", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DistritoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>>handleDistritoNoEncontrado(DistritoNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Provincia no encontrada", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    @ExceptionHandler(DireccionNoEncontradaException.class)
    public ResponseEntity<Map<String, Object>> handleDireccionNoEncontrada(DireccionNoEncontradaException ex) {
        Map<String, Object> response = responseMap("Direccion no encontrada", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PacienteNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handlePacienteNoEncontrado(PacienteNoEncontradoException ex) {
        Map<String, Object> response = responseMap("Paciente no encontrado", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
