package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Distrito;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public Optional<Distrito> findById(Integer id) {
        return distritoRepository.findById(id);
    }

    @Override
    public List<Distrito> findAllByProvinciaId(Integer provincia_id) {
        return distritoRepository.findByProvinciaId(provincia_id);
    }

    @Override
    public List<Distrito> findAllByDepartamentoId(Integer provinciaId) {
        return List.of();
    }
}
