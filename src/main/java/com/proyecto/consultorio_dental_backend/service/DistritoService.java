package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.response.DistritoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistritoService {

    DistritoResponseDTO findById(Integer id);

    List<DistritoResponseDTO> findAllByProvinciaId (Integer provincia_id);

    List<DistritoResponseDTO> findAllByDepartamentoId(Integer provinciaId);

    List<DistritoResponseDTO> findAll();

    Page<DistritoResponseDTO> findAllPaged(Pageable pageable);

    Page<DistritoResponseDTO> findAllByNombreLikePaged(Pageable pageable, String nombre);

}
