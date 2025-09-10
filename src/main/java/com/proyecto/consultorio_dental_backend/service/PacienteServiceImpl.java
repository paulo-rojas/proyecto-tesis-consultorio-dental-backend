package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.exception.DniInvalidoException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.mapper.PacienteMapper;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteResponseDTO findByDni(String dni) {

        if (!CommonUtils.isValidDni(dni)){
            throw new DniInvalidoException(dni);
        }

        return pacienteRepository.findByDni(dni)
                .map(PacienteMapper::toDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(null));
    }

    @Override
    public PacienteResponseDTO findById(Integer id) {
        return pacienteRepository.findById(id)
                .map(PacienteMapper::toDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(id));
    }

    @Override
    public List<PacienteResponseDTO> findAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public PacienteResponseDTO save(PacienteRequestDTO paciente) {
        PacienteEntity pacienteEntity = PacienteMapper.toEntity(paciente);
        pacienteRepository.save(pacienteEntity);
        return PacienteMapper.toDTO(pacienteEntity);
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        PacienteEntity entity = pacienteRepository
                .findById(id)
                .orElseThrow(() -> new PersonaNoEncontradaException(id));

        entity.setEstado(false);
        pacienteRepository.save(entity);
    }

    @Override
    @Transactional
    public void updateOcupacion(Integer pacienteId, String ocupacion) {
        PacienteEntity entity = pacienteRepository.findById(pacienteId)
                .orElseThrow( () -> new PersonaNoEncontradaException(pacienteId));

        entity.setOcupacion(ocupacion);
        pacienteRepository.save(entity);
    }

    @Override
    public List<PacienteResponseDTO> findByNombreCompletoLike(String nombreCompleto) {
        return pacienteRepository.findByNombreCompletoLike("%"+nombreCompleto+"%")
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

}
