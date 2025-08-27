package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
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
    public Optional<PacienteEntity> findByDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

    @Override
    public Optional<PacienteEntity> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<PacienteEntity> findAll(){
        return pacienteRepository.findAll();
    }

    @Override
    public void save(PacienteEntity paciente) {
        pacienteRepository.save(paciente);
    }
}
