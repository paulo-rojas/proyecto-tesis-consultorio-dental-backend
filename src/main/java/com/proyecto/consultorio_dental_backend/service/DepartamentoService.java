package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    Optional<Departamento> findById(Integer id);

    List<Departamento> findAll();
}
