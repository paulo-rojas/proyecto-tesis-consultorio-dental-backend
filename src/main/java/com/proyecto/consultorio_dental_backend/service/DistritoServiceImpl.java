package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.exception.DepartamentoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.DistritoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.exception.ProvinciaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.mapper.DistritoMapper;
import com.proyecto.consultorio_dental_backend.repository.DepartamentoRepository;
import com.proyecto.consultorio_dental_backend.repository.DistritoRepository;
import com.proyecto.consultorio_dental_backend.repository.ProvinciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService{

    private final DistritoRepository distritoRepository;
    private final ProvinciaRepository provinciaRepository;
    private final DepartamentoRepository departamentoRepository;

    public DistritoServiceImpl(DistritoRepository distritoRepository, ProvinciaRepository provinciaRepository, DepartamentoRepository departamentoRepository) {
        this.distritoRepository = distritoRepository;
        this.provinciaRepository = provinciaRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public DistritoDTO findById(Integer id) {
        return distritoRepository
                .findById(id)
                .map(DistritoMapper::toDTO)
                .orElseThrow( () -> new DistritoNoEncontradoException(id));
    }

    @Override
    public List<DistritoDTO> findAllByProvinciaId(Integer provinciaId) {

        if (!provinciaRepository.existsById(provinciaId)){
            throw new ProvinciaNoEncontradaException(provinciaId);
        }

        return distritoRepository.findAllByProvinciaId(provinciaId)
                .stream()
                .map(DistritoMapper::toDTO)
                .toList();
    }

    @Override
    public List<DistritoDTO> findAllByDepartamentoId(Integer departamentoId) {

        if(!departamentoRepository.existsById(departamentoId)){
            throw new DepartamentoNoEncontradoException(departamentoId);
        }

        return distritoRepository.findAllByDepartamentoId(departamentoId)
                .stream()
                .map(DistritoMapper::toDTO)
                .toList();
    }

    @Override
    public List<DistritoDTO> findAll() {
        return distritoRepository.findAll()
                .stream()
                .map(DistritoMapper::toDTO)
                .toList();
    }

    @Override
    public Page<DistritoDTO> findAllPaged(Pageable pageable) {
        return distritoRepository.findAllPaged(pageable)
                .map(DistritoMapper::toDTO);
    }

    @Override
    public Page<DistritoDTO> findAllByNombreLikePaged(Pageable pageable, String nombre) {
        return distritoRepository.findAllByNombreLikePaged("%" + nombre + "%",pageable)
                .map(DistritoMapper::toDTO);
    }

}
