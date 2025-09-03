package com.proyecto.consultorio_dental_backend.controller;


import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/direccion")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<DireccionResponseDTO> direccion = direccionService.findById(id);
        return direccion
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/")
    public ResponseEntity<?> updateDireccion(@RequestBody DireccionRequestDTO dto){
    // TO - FIX
        return direccionService.update(dto)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body(CommonUtils.errorMessageMap("Error al actualizar"));

    }
}
