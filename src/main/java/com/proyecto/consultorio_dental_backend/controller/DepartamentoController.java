package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.DepartamentoEntity;
import com.proyecto.consultorio_dental_backend.mapper.PacienteMapper;
import com.proyecto.consultorio_dental_backend.service.DepartamentoService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartamentoEntity>> findAll(){

        List<DepartamentoEntity> departamentos = departamentoService.findAll();
        return departamentos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoEntity> findById(@PathVariable Integer id){

        DepartamentoEntity departamento = departamentoService.findById(id);
        return ResponseEntity.ok(departamento);
    }
}
