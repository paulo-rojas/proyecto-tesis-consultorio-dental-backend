package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoCuentaConDireccionException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
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
    public PacienteDTO findByDni(String dni) {
        return pacienteRepository.findByDni(dni).map(PacienteMapper::toDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(null));
    }

    @Override
    public PacienteDTO findById(Integer id) {
        return pacienteRepository.findById(id).map(PacienteMapper::toDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(id));
    }

    @Override
    public List<PacienteDTO> findAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    public PacienteDTO save(PacienteDTO paciente) {
        PacienteEntity entity = pacienteRepository.save(PacienteMapper.toEntity(paciente));
        return PacienteMapper.toDTO(entity);
    }

}
