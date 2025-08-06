package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Paciente;
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
    public Optional<Paciente> findByDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

    @Override
    public Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    @Override
    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
