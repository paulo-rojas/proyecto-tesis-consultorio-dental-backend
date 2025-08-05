package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Departamento;
import com.proyecto.consultorio_dental_backend.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Optional<Departamento> findById(Integer id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }
}
