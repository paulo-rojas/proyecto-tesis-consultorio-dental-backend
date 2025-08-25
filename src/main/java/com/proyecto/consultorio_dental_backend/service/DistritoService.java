package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;

import java.util.List;
import java.util.Optional;

public interface DistritoService {

    Optional<DistritoDTO> findById(Integer id);

    List<DistritoDTO> findAllByProvinciaId (Integer provincia_id);

    List<DistritoDTO> findAllByDepartamentoId(Integer provinciaId);
}
