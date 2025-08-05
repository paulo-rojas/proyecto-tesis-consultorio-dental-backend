package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;
import com.proyecto.consultorio_dental_backend.entity.Direccion;
import com.proyecto.consultorio_dental_backend.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Optional<DireccionDTO> findById(Integer id) {
        Optional<Direccion> direccion = direccionRepository.findById(id);
        return Optional.of(new DireccionDTO(direccion.get().getDescripcion(),
                direccion.get().getDistrito().getNombre(),
                direccion.get().getDistrito().getProvincia().getNombre(),
                direccion.get().getDistrito().getProvincia().getDepartamento().getNombre()));
    }
}
