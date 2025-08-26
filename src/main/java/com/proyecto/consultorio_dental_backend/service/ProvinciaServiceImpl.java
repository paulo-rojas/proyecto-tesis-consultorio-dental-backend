package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.ProvinciaDTO;
import com.proyecto.consultorio_dental_backend.entity.ProvinciaEntity;
import com.proyecto.consultorio_dental_backend.mapper.ProvinciaMapper;
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
    public Optional<ProvinciaDTO> findById(Integer id) {
        return provinciaRepository.findById(id)
                .map(ProvinciaMapper::toDTO);
    }


    @Override
    public List<ProvinciaDTO> findAllByDepartamentoId(Integer id) {
        return provinciaRepository.findAllByDepartamentoId(id)
                .stream()
                .map(ProvinciaMapper::toDTO)
                .toList();
    }
}
