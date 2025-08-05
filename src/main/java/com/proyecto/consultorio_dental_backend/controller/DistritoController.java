package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.Distrito;
import com.proyecto.consultorio_dental_backend.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/provincias/{provincia_id}/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public List<Distrito> findAllByDepartamentoId(@PathVariable Integer provincia_id){
        return distritoService.findAllByProvinciaId(provincia_id);
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById (@PathVariable Integer id){
        return distritoService.findById(id);
    }


}
