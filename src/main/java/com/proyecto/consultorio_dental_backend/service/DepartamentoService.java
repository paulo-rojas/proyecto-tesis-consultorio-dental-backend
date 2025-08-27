package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.DepartamentoEntity;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    Optional<DepartamentoEntity> findById(Integer id);

    List<DepartamentoEntity> findAll();
}
