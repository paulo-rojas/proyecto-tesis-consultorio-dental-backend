package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.DepartamentoEntity;

import java.util.List;

public interface DepartamentoService {

    DepartamentoEntity findById(Integer id);

    List<DepartamentoEntity> findAll();
}
