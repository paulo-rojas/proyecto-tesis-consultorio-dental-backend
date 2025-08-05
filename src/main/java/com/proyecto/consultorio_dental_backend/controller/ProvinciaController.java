package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.Provincia;
import com.proyecto.consultorio_dental_backend.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos/{departamento_id}/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping
    public List<Provincia> findAllByDepartamentoId(@PathVariable Integer departamento_id){
        return provinciaService.findAllByDepartamentoId(departamento_id);
    }

    @GetMapping("/{id}")
    public Optional<Provincia> findById (@PathVariable Integer id){
        return provinciaService.findById(id);
    }

}
