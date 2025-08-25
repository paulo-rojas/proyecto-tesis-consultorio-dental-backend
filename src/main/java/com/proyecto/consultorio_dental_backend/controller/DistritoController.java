package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.Distrito;
import com.proyecto.consultorio_dental_backend.service.DistritoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    private final DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService;
    }

    @GetMapping("/find-all-by-departamento-id/{departamento_id}")
    public List<Distrito> findAllByDepartamentoId(@PathVariable Integer departamento_id){
        return distritoService.findAllByDepartamentoId(departamento_id);
    }

    @GetMapping("/find-all-by-provincia-id/{provincia_id}")
    public List<Distrito> findAllByProvinciaId(@PathVariable Integer provincia_id){
        return distritoService.findAllByProvinciaId(provincia_id);
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Distrito> findById (@PathVariable Integer id){
        return distritoService.findById(id);
    }
}