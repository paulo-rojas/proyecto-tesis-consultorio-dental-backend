package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;

import java.util.List;
import java.util.Optional;

public interface DistritoService {

    Optional<DistritoDTO> findById(Integer id);

    List<DistritoDTO> findAllByProvinciaId (Integer provincia_id);

    List<DistritoDTO> findAllByDepartamentoId(Integer provinciaId);

    List<DistritoDTO> findAll();
}
