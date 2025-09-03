package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;

public interface DireccionService {

    DireccionResponseDTO findById(Integer id);

    boolean update(DireccionRequestDTO dto);

    DireccionResponseDTO findByPacienteId(Integer pacienteId);

    DireccionResponseDTO findByMedicoId(Integer medicoId);

    DireccionResponseDTO addDireccionToPaciente(Integer pacienteId, DireccionRequestDTO direccionRequestDTO);
}
