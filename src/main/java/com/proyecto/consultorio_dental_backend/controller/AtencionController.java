package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.AtencionDTO;
import com.proyecto.consultorio_dental_backend.service.AtencionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atenciones")
public class AtencionController {

    private final AtencionService atencionService;


    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    @GetMapping
    public ResponseEntity<?> findAll (){
        List<AtencionDTO> atenciones = atencionService.findAll();

        return atenciones.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable Integer id){
        return Optional.ofNullable(atencionService.findById(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody AtencionDTO atencionDTO){
        AtencionDTO atencionGuardada = atencionService.save(atencionDTO);
        return ResponseEntity.ok(atencionGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody AtencionDTO atencionDTO, @PathVariable Integer id){
        atencionDTO.setId(id);
        atencionService.save(atencionDTO);
        return ResponseEntity.ok().build();
    }
}
