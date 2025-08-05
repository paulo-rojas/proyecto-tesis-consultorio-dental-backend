package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Provincia;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {

    Optional<Provincia> findById(Integer id);

    //List<Provincia> findAll();

    List<Provincia> findAllByDepartamentoId(Integer id);
}
