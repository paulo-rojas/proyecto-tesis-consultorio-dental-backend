package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.exception.DireccionNoEncontradaException;
import com.proyecto.consultorio_dental_backend.exception.PacienteNoEncontradoException;
import com.proyecto.consultorio_dental_backend.mapper.DireccionMapper;
import com.proyecto.consultorio_dental_backend.repository.DireccionRepository;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService{

    private final DireccionRepository direccionRepository;
    private final DistritoRepository distritoRepository;
    private final PacienteRepository pacienteRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository, DistritoRepository distritoRepository, PacienteRepository pacienteRepository) {
        this.direccionRepository = direccionRepository;
        this.distritoRepository = distritoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public DireccionResponseDTO findById(Integer id) {
        return direccionRepository.findById(id)
                .map(DireccionMapper::toDTO)
                .orElseThrow( () -> new DireccionNoEncontradaException("Entidad", id));
    }

    @Override
    public boolean update(DireccionRequestDTO dto) {

        Optional<DireccionEntity> direccionExistente = direccionRepository.findById(dto.getId());
        if (direccionExistente.isEmpty()) {
            return false; // No existe la dirección a actualizar
        }

        Optional<DistritoEntity> distritoEntity = distritoRepository.findById(dto.getDistritoId());
        if (distritoEntity.isEmpty()) {
            return false; // No existe el distrito
        }

        DireccionEntity direccionEntity = DireccionMapper.toEntity(dto, distritoEntity.get());
        DireccionEntity direccionGuardada = direccionRepository.save(direccionEntity);

        return true;
    }

    @Override
    public DireccionResponseDTO findByPacienteId(Integer id) {

        PacienteEntity paciente = pacienteRepository.findById(id)
                .orElseThrow( () -> new PacienteNoEncontradoException(id));

        return Optional.ofNullable(paciente.getDireccion())
                .map(DireccionMapper::toDTO)
                .orElseThrow( () -> new DireccionNoEncontradaException("Paciente", id));
    }

    @Override
    public DireccionResponseDTO findByMedicoId(Integer medicoId) {
        // TO - DO
        return null;
    }

}
