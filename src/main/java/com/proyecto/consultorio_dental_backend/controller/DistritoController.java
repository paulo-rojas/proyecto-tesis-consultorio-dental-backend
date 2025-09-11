package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.response.DistritoResponseDTO;
import com.proyecto.consultorio_dental_backend.service.DistritoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    private final DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DistritoResponseDTO>> findAll(){
        return ResponseEntity.ok(distritoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritoResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(distritoService.findById(id));
    }

    // En DistritoController.java
    @GetMapping("/page")
    public ResponseEntity<Page<DistritoResponseDTO>> findAllPaged(
            @RequestParam(value ="page",defaultValue = "0")  Integer page,
            @RequestParam(value ="size",defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<DistritoResponseDTO> distritos = distritoService.findAllPaged(pageable);
        return ResponseEntity.ok(distritos);
    }

    @GetMapping("/provincia/{provinciaId}")
    public ResponseEntity<List<DistritoResponseDTO>> findAllByProvinciaId(@PathVariable Integer provinciaId){
        List<DistritoResponseDTO> distritos =distritoService.findAllByProvinciaId(provinciaId);
        return distritos.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(distritos);
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<DistritoResponseDTO>> findAllByDepartamentoId(@PathVariable Integer departamentoId){
        List<DistritoResponseDTO> distritos = distritoService.findAllByDepartamentoId(departamentoId);
        return distritos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(distritos);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DistritoResponseDTO>> findByNombreLikePaged(
            @RequestParam(value = "nombre", defaultValue = "") String nombre,
            @RequestParam(value ="page",defaultValue = "0")  Integer page,
            @RequestParam(value ="size",defaultValue = "10") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(distritoService.findAllByNombreLikePaged(pageable, nombre));
    }
}