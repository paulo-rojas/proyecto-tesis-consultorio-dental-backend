package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<PacienteDTO> findByDni(String dni);

    Optional<PacienteDTO> findById(Integer id);

    List<PacienteDTO> findAll();

    void save(PacienteDTO paciente);

    boolean existsById(Integer id);
}
