package com.proyecto.consultorio_dental_backend.controller;

import com.proyecto.consultorio_dental_backend.entity.Paciente;
import com.proyecto.consultorio_dental_backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    List<Paciente> findAll(){
       return pacienteService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    Optional<Paciente> findById(@PathVariable Integer id){
        return pacienteService.findById(id);
    }

    @GetMapping("/find-by-dni/{dni}")
    Optional<Paciente> findByDni(@PathVariable String dni){
        return pacienteService.findByDni(dni);
    }

    @PostMapping
    void save(@RequestBody Paciente paciente){
        pacienteService.save(paciente);
    }
}
