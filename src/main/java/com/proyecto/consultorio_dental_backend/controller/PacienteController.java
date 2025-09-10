package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.dto.*;
import com.proyecto.consultorio_dental_backend.service.ContactoService;
import com.proyecto.consultorio_dental_backend.service.DireccionService;
import com.proyecto.consultorio_dental_backend.service.PacienteService;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final DireccionService direccionService;
    private final ContactoService contactoService;

    public PacienteController(PacienteService pacienteService, DireccionService direccionService, ContactoService contactoService) {
        this.pacienteService = pacienteService;
        this.direccionService = direccionService;
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){

        List<PacienteResponseDTO> pacientes = pacienteService.findAll();

        return pacientes.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        return Optional.ofNullable(pacienteService.findById(id))
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> findByDni(@PathVariable String dni){

        return Optional.ofNullable(pacienteService.findByDni(dni))
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.noContent().build());
    }

    // TO-DO
    @GetMapping("/search-by-name")
    public ResponseEntity<?> findByNombreCompletoLike
            (@RequestParam(value = "nombreCompleto", defaultValue = "") String nombre){

        List<PacienteResponseDTO> pacientes = pacienteService.findByNombreCompletoLike(nombre);
        return pacientes.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> save(@Valid @RequestBody PacienteRequestDTO paciente) {

        PacienteResponseDTO pacienteGuardado = pacienteService.save(paciente);

        // Esto crea una URL como "http://localhost:8080/api/pacientes/123"
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Toma la URL base de la petición actual (ej: /api/pacientes)
                .path("/{id}")       // Le añade "/{id}"
                .buildAndExpand(pacienteGuardado.getId()) // Reemplaza {id} con el ID del paciente guardado
                .toUri();

        return ResponseEntity.created(location).body(pacienteGuardado);
    }

    // OCUPACIÓN

    @PutMapping("{pacienteId}/ocupacion")
    public ResponseEntity<?> updateOcupacion(
            @PathVariable Integer pacienteId,
            @RequestParam(value = "ocupacion", defaultValue = "") String Ocupacion){
        pacienteService.updateOcupacion(pacienteId, Ocupacion);
        return ResponseEntity.noContent().build();
    }

    // Direccion

    @GetMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> findDireccion(@PathVariable Integer pacienteId){
        DireccionResponseDTO direccion = direccionService.findDireccionByPersonaId(pacienteId);
        return ResponseEntity.ok(direccion);
    }

    @PostMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> addDireccion(@PathVariable Integer pacienteId, @RequestBody DireccionRequestDTO direccionRequestDTO){
        DireccionResponseDTO direccionResponseDTO = direccionService.addDireccionToPersona(pacienteId, direccionRequestDTO);
        URI location = URI.create("/pacientes/" + pacienteId + "/direccion");
        return ResponseEntity.created(location).body(direccionResponseDTO);
    }

    @PutMapping("/{pacienteId}/direccion")
    public ResponseEntity<DireccionResponseDTO> updateDireccion (@PathVariable Integer pacienteId, @RequestBody DireccionRequestDTO direccionRequestDTO){
        DireccionResponseDTO direccion = direccionService.updateDireccion(pacienteId,direccionRequestDTO);
        return ResponseEntity.ok(direccion);
    }

    @DeleteMapping("/{pacienteId}/direccion")
    public ResponseEntity<?> deleteDireccion (@PathVariable Integer pacienteId){
        direccionService.deleteDireccion(pacienteId);
        return ResponseEntity.noContent().build();
    }

    // CONTACTO

    @GetMapping("/{pacienteId}/contacto")
    public ResponseEntity<ContactoDTO> findContacto(@PathVariable Integer pacienteId){
        ContactoDTO contacto = contactoService.findContactoByPersonaId(pacienteId);
        return ResponseEntity.ok(contacto);
    }

    @PostMapping("/{pacienteId}/contacto")
    public ResponseEntity<ContactoDTO> addContacto(@PathVariable Integer pacienteId, @RequestBody ContactoDTO contactoDTO){
        ContactoDTO contacto = contactoService.addContactoToPersona(pacienteId, contactoDTO);
        URI location = URI.create("/pacientes/" + pacienteId + "/contacto");
        return ResponseEntity.created(location).body(contacto);
    }

    @PutMapping("/{pacienteId}/contacto")
    public ResponseEntity<ContactoDTO> updateContacto (@PathVariable Integer pacienteId, @RequestBody ContactoDTO contactoDTO){
        ContactoDTO contacto = contactoService.updateContacto(pacienteId,contactoDTO);
        return ResponseEntity.ok(contacto);
    }

    @DeleteMapping("/{pacienteId}/contacto")
    public ResponseEntity<?> deleteContacto (@PathVariable Integer pacienteId){
        contactoService.deleteContacto(pacienteId);
        return ResponseEntity.noContent().build();
    }

}