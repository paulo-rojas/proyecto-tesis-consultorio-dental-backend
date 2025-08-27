package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.service.PacienteService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){

        List<PacienteEntity> pacientes = pacienteService.findAll();

        return pacientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        if (!CommonUtils.isValidId(id)) {
            Map<String, String> errorMap = Map.of("Error", String.format("El id ingresado: %d no es válido", id));
            return ResponseEntity.badRequest().body(errorMap);
        }

        return pacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/find-by-dni/{dni}")
    public ResponseEntity<?> findByDni(@PathVariable String dni){

        if (!CommonUtils.isValidDni(dni)){
            Map<String, String> errorMap = Map.of("Error", String.format("El dni ingresado: %s no es válido", dni));
            return ResponseEntity.badRequest().body(errorMap);
        }

        return pacienteService.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public void save(@RequestBody PacienteEntity paciente){
        pacienteService.save(paciente);
    }
}
