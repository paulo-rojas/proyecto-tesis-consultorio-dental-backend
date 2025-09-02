package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<PacienteDTO> findByDni(String dni);

    Optional<PacienteDTO> findById(Integer id);

    List<PacienteDTO> findAll();

    void save(PacienteDTO paciente);

    boolean existsById(Integer id);

    ResponseEntity<?> saveDireccion(Integer id, DireccionRequestDTO direccionRequestDTO);
}
