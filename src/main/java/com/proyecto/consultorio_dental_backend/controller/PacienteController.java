package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
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

    @PostMapping("/{id}/direccion")
    public ResponseEntity<?> saveDireccion(@PathVariable Integer id,
                                           @RequestBody DireccionRequestDTO dto) {
        try {
            ResponseEntity<?> responseEntity  = pacienteService.saveDireccion(id, dto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(CommonUtils.errorMessageMap(e.getMessage()));
        }
    }

    @PostMapping
    public void save(@RequestBody PacienteDTO paciente){
        pacienteService.save(paciente);
    }
}
