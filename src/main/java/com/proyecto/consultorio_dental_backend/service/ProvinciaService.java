package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.ProvinciaDTO;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {

    Optional<ProvinciaDTO> findById(Integer id);

    //List<Provincia> findAll();

    List<ProvinciaDTO> findAllByDepartamentoId(Integer id);
}
