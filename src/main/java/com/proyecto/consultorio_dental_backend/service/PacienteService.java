package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteResponseDTO;

import java.util.List;

public interface PacienteService {

    PacienteResponseDTO findByDni(String dni);

    PacienteResponseDTO findById(Integer id);

    List<PacienteResponseDTO> findAll();

    PacienteResponseDTO save(PacienteRequestDTO paciente);

    void delete(Integer id);
}
