package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.Distrito;

import java.util.List;
import java.util.Optional;

public interface DistritoService {

    Optional<Distrito> findById(Integer id);
    List<Distrito> findAllByProvinciaId (Integer provincia_id);
}
