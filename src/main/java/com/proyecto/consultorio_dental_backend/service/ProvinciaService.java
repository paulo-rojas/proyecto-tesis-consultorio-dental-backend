package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.ProvinciaEntity;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {

    Optional<ProvinciaEntity> findById(Integer id);

    //List<Provincia> findAll();

    List<ProvinciaEntity> findAllByDepartamentoId(Integer id);
}
