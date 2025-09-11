package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.DireccionResponseDTO;

public interface DireccionService {

    DireccionResponseDTO findDireccionByPersonaId(Integer personaId);

    DireccionResponseDTO addDireccionToPersona(Integer personaId, DireccionRequestDTO direccionRequestDTO);

    DireccionResponseDTO updateDireccion(Integer personaId, DireccionRequestDTO dto);

    void deleteDireccion(Integer personaId);
}
