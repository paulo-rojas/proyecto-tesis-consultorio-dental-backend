package com.proyecto.consultorio_dental_backend.controller;


import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/direccion")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/{id}")
    public Optional<DireccionDTO> findById(@PathVariable Integer id){
        return direccionService.findById(id);
    }
}
