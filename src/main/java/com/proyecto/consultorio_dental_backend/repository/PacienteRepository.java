package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    Optional<Paciente> findByDni(String dni);
}
