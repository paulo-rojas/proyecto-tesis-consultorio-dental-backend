package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;

import java.util.Optional;

public interface DireccionService {

    Optional<DireccionDTO> findById(Integer id);
}
