package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import com.proyecto.consultorio_dental_backend.service.PacienteService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final DireccionService direccionService;

    public PacienteController(PacienteService pacienteService, DireccionService direccionService) {
        this.pacienteService = pacienteService;
        this.direccionService = direccionService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){

        List<PacienteDTO> pacientes = pacienteService.findAll();

        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        if (!CommonUtils.isValidId(id)) {
            return ResponseEntity.badRequest()
                    .body(CommonUtils.errorMessageMap(String.format("El id %s no es válido", id)));
        }

        return pacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> findByDni(@PathVariable String dni){

        if (!CommonUtils.isValidDni(dni)){
            Map<String, String> errorMap = Map.of("Error", String.format("El dni ingresado: %s no es válido", dni));
            return ResponseEntity.badRequest().body(errorMap);
        }

        return pacienteService.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<?> findByNombreCompletoLike
            (@RequestParam(value = "nombreCompleto", defaultValue = "") String nombre){


        return null;
    }

    @PostMapping
    public void save(@RequestBody PacienteDTO paciente){
        pacienteService.save(paciente);
    }

    // Direccion

    @GetMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> findDireccion(@PathVariable Integer pacienteId){
        DireccionResponseDTO direccion = direccionService.findDireccionByPacienteId(pacienteId);
        return ResponseEntity.ok(direccion);
    }

    @PostMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> addDireccion(@PathVariable Integer pacienteId, @RequestBody DireccionRequestDTO direccionRequestDTO){
        DireccionResponseDTO direccionResponseDTO = direccionService.addDireccionToPaciente(pacienteId, direccionRequestDTO);
        URI location = URI.create("/pacientes/" + pacienteId + "/direccion");
        return ResponseEntity.created(location).body(direccionResponseDTO);
    }

    @PutMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> updateDireccion (@PathVariable Integer pacienteId, @RequestBody DireccionRequestDTO direccionRequestDTO){
        DireccionResponseDTO direccion = direccionService.updateDireccionToPaciente(pacienteId,direccionRequestDTO);
        return ResponseEntity.ok(direccion);
    }

    @DeleteMapping("/{pacienteId}/direccion")
    public ResponseEntity<?> deleteDireccion (@PathVariable Integer pacienteId){
        direccionService.deleteDireccionToPaciente(pacienteId);
        return ResponseEntity.noContent().build();
    }


}