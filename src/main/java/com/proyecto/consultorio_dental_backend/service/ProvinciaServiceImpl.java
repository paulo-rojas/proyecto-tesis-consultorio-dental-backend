package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.ProvinciaEntity;
import com.proyecto.consultorio_dental_backend.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Optional<ProvinciaEntity> findById(Integer id) {
        return provinciaRepository.findById(id);
    }

    /*
    @Override
    public List<Provincia> findAll() {
        return provinciaRepository.findAll();
    }
    */

    @Override
    public List<ProvinciaEntity> findAllByDepartamentoId(Integer id) {
        return provinciaRepository.findAllByDepartamentoId(id);
    }
}
