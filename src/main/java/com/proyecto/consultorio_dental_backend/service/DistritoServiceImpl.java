package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import com.proyecto.consultorio_dental_backend.mapper.DistritoMapper;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService{

    private final DistritoRepository distritoRepository;
    private final DistritoMapper distritoMapper;

    public DistritoServiceImpl(DistritoRepository distritoRepository, DistritoMapper distritoMapper) {
        this.distritoRepository = distritoRepository;
        this.distritoMapper = distritoMapper;
    }

    @Override
    public Optional<DistritoDTO> findById(Integer id) {
        return distritoRepository.findById(id).map(DistritoMapper::toDTO);
    }

    @Override
    public List<DistritoDTO> findAllByProvinciaId(Integer provinciaId) {
        return distritoRepository.findAllByProvinciaId(provinciaId)
                .stream()
                .map(DistritoMapper::toDTO)
                .toList();
    }

    @Override
    public List<DistritoDTO> findAllByDepartamentoId(Integer departamentoId) {
        return distritoRepository.findAllByDepartamentoId(departamentoId)
                .stream()
                .map(DistritoMapper::toDTO)
                .toList();
    }
}
