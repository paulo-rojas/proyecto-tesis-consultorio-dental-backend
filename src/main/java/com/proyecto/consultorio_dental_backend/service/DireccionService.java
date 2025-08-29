package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;

import java.util.Optional;

public interface DireccionService {

    Optional<DireccionResponseDTO> findById(Integer id);

    boolean update(DireccionRequestDTO dto);
}
