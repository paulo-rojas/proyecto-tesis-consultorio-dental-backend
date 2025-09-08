package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
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
    public ResponseEntity<List<DistritoDTO>> findAll(){
        return ResponseEntity.ok(distritoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(distritoService.findById(id));
    }

    // En DistritoController.java
    @GetMapping("/page")
    public ResponseEntity<Page<DistritoDTO>> findAllPaged(
            @RequestParam(value ="page",defaultValue = "0")  Integer page,
            @RequestParam(value ="size",defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<DistritoDTO> distritos = distritoService.findAllPaged(pageable);
        return ResponseEntity.ok(distritos);
    }

    @GetMapping("/provincia/{provinciaId}")
    public ResponseEntity<List<DistritoDTO>> findAllByProvinciaId(@PathVariable Integer provinciaId){
        List<DistritoDTO> distritos =distritoService.findAllByProvinciaId(provinciaId);
        return distritos.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(distritos);
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<DistritoDTO>> findAllByDepartamentoId(@PathVariable Integer departamentoId){
        List<DistritoDTO> distritos = distritoService.findAllByDepartamentoId(departamentoId);
        return distritos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(distritos);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DistritoDTO>> findByNombreLikePaged(
            @RequestParam(value = "nombre", defaultValue = "") String nombre,
            @RequestParam(value ="page",defaultValue = "0")  Integer page,
            @RequestParam(value ="size",defaultValue = "10") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(distritoService.findAllByNombreLikePaged(pageable, nombre));
    }
}