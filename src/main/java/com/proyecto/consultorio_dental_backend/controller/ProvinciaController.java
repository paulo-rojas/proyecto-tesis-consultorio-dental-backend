package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.response.ProvinciaResponseDTO;
import com.proyecto.consultorio_dental_backend.service.ProvinciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("/find-all-by-departamento-id/{departamento_id}")
    public ResponseEntity<List<ProvinciaResponseDTO>> findAllByDepartamentoId(@PathVariable Integer departamento_id){
        return Optional.of(provinciaService.findAllByDepartamentoId(departamento_id))
                .filter(list -> !list.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ProvinciaResponseDTO> findById (@PathVariable Integer id){
        return provinciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

}
