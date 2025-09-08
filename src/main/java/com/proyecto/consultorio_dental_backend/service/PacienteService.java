package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    PacienteDTO findByDni(String dni);

    PacienteDTO findById(Integer id);

    List<PacienteDTO> findAll();

    PacienteDTO save(PacienteDTO paciente);
}
