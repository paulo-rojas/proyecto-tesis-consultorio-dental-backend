package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.mapper.PacienteMapper;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Optional<PacienteDTO> findByDni(String dni) {
        return pacienteRepository.findByDni(dni).map(PacienteMapper::toDTO);
    }

    @Override
    public Optional<PacienteDTO> findById(Integer id) {
        return pacienteRepository.findById(id).map(PacienteMapper::toDTO);
    }

    @Override
    public List<PacienteDTO> findAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    public void save(PacienteDTO paciente) {
        pacienteRepository.save(PacienteMapper.toEntity(paciente));
    }

    @Override
    public boolean existsById(Integer id) {
        return pacienteRepository.existsById(id);
    }
}
