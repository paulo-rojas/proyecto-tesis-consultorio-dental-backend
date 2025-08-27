package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<PacienteEntity> findByDni(String dni);

    Optional<PacienteEntity> findById(Integer id);

    List<PacienteEntity> findAll();

    void save(PacienteEntity paciente);
}
