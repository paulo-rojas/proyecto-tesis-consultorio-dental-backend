package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.response.ProvinciaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {

    Optional<ProvinciaResponseDTO> findById(Integer id);

    //List<Provincia> findAll();

    List<ProvinciaResponseDTO> findAllByDepartamentoId(Integer id);
}
