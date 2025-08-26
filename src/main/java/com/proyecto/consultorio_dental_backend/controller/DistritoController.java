package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.mapper.DistritoMapper;
import com.proyecto.consultorio_dental_backend.service.DistritoService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<DistritoDTO> findById(@PathVariable Integer id) {

        if (CommonUtils.isValidId(id)) {
            return ResponseEntity.badRequest().build();
        }

        return distritoService.findById(id)
                .map(dis -> ResponseEntity.ok().body(dis))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<DistritoDTO>> findAll(){

        List<DistritoDTO> distritos = distritoService.findAll();

        return Optional.of(distritos)
                .filter(list -> !list.isEmpty())
                .map(dis -> ResponseEntity.ok().body(dis))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/find-all-by-provincia-id/{provincia_id}")
    public ResponseEntity<List<DistritoDTO>> findAllByProvinciaId(@PathVariable Integer provincia_id){


        List<DistritoDTO> distritos = distritoService.findAllByProvinciaId(provincia_id);

        return Optional.of(distritos)
                .filter(list -> !list.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/find-all-by-departamento-id/{departamento_id}")
    public ResponseEntity<List<DistritoDTO>> findAllByDepartamentoId(@PathVariable Integer departamento_id){

        if (CommonUtils.isValidId(departamento_id)){
            return ResponseEntity.badRequest().build();
        }

        List<DistritoDTO> distritos = distritoService.findAllByDepartamentoId(departamento_id);

        return distritos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(distritos);
    }


}