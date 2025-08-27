package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;
import com.proyecto.consultorio_dental_backend.mapper.DireccionMapper;
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
        return direccionRepository.findById(id)
                .map(DireccionMapper::toDTO);
    }
}
