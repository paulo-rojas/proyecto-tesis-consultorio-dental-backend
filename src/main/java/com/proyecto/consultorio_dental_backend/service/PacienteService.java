package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<Paciente> findByDni(String dni);

    Optional<Paciente> findById(Integer id);

    List<Paciente> findAll();

    void save(Paciente paciente);
}
