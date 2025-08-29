package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.mapper.PacienteMapper;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Optional<PacienteDTO> findByDni(String dni) {
        return pacienteRepository.findByDni(dni).map(PacienteMapper::toDTO);
    }

    @Override
    public Optional<PacienteDTO> findById(Integer id) {
        return pacienteRepository.findById(id).map(PacienteMapper::toDTO);
    }

    @Override
    public List<PacienteDTO> findAll(){
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    @Override
    public void save(PacienteDTO paciente) {
        pacienteRepository.save(PacienteMapper.toEntity(paciente));
    }
}
