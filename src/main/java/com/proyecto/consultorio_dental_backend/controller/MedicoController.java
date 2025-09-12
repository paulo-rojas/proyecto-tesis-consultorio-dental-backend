package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll () {
        List<MedicoResponseGeneralDTO> medicos = medicoService.findAll();

        return medicos.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Integer id) {
        return Optional.ofNullable(medicoService.findById(id))
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getByDni (@PathVariable String dni){
        return Optional.ofNullable(medicoService.findByDni(dni))
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<?> getByEspecialidad (@PathVariable String especialidad){
        List<MedicoResponseGeneralDTO> medicos;
    }
}
