package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.mapper.DistritoMapper;
import com.proyecto.consultorio_dental_backend.service.DistritoService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    private final DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DistritoDTO>> findAll(){

        List<DistritoDTO> distritos = distritoService.findAll();

        return Optional.of(distritos)
                .filter(list -> !list.isEmpty())
                .map(dis -> ResponseEntity.ok().body(dis))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritoDTO> findById(@PathVariable Integer id) {

        if (CommonUtils.isValidId(id)) {
            return ResponseEntity.badRequest().build();
        }

        return distritoService.findById(id)
                .map(dis -> ResponseEntity.ok().body(dis))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DistritoDTO>> findAllPaged(
            @RequestParam(value ="page",defaultValue = "0")  Integer page,
            @RequestParam(value ="size",defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page, size);

        Page<DistritoDTO> distritos = distritoService.findAllPaged(pageable);

        if (distritos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(distritos);
    }

    @GetMapping("/provincia/{provinciaId}")
    public ResponseEntity<List<DistritoDTO>> findAllByProvinciaId(@PathVariable Integer provinciaId){

        List<DistritoDTO> distritos = distritoService.findAllByProvinciaId(provinciaId);

        return Optional.of(distritos)
                .filter(list -> !list.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<DistritoDTO>> findAllByDepartamentoId(@PathVariable Integer departamentoId){

        if (CommonUtils.isValidId(departamentoId)){
            return ResponseEntity.badRequest().build();
        }

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
        Page<DistritoDTO> distritoDTOPage = distritoService.findAllByNombreLikePaged(pageable, nombre);

        if (distritoDTOPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(distritoDTOPage);

    }
}