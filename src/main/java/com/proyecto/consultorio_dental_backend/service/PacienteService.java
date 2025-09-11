package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.PacienteRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.PacienteResponseDTO;

import java.util.List;

public interface PacienteService {

    PacienteResponseDTO findByDni(String dni);

    PacienteResponseDTO findById(Integer id);

    List<PacienteResponseDTO> findAll();

    PacienteResponseDTO save(PacienteRequestDTO paciente);

    void delete(Integer id);

    void updateOcupacion(Integer pacienteId, String ocupacion);

    List<PacienteResponseDTO> findByNombreCompletoLike(String nombre);
}
