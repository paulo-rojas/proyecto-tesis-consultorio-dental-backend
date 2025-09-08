package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;

public interface DireccionService {

    /**
     * Busca la dirección asociada a una persona (paciente o médico).
     * @param personaId El ID de la persona.
     * @return El DTO de la dirección.
     */
    DireccionResponseDTO findDireccionByPersonaId(Integer personaId);

    /**
     * Añade una nueva dirección a una persona que no tiene una.
     * @param personaId El ID de la persona.
     * @param direccionRequestDTO Los datos de la nueva dirección.
     * @return El DTO de la dirección creada.
     */
    DireccionResponseDTO addDireccionToPersona(Integer personaId, DireccionRequestDTO direccionRequestDTO);

    /**
     * Actualiza la dirección existente de una persona.
     * @param personaId El ID de la persona.
     * @param dto Los nuevos datos de la dirección.
     * @return El DTO de la dirección actualizada.
     */
    DireccionResponseDTO updateDireccion(Integer personaId, DireccionRequestDTO dto);

    /**
     * Elimina la dirección asociada a una persona.
     * @param personaId El ID de la persona.
     */
    void deleteDireccion(Integer personaId);
}
