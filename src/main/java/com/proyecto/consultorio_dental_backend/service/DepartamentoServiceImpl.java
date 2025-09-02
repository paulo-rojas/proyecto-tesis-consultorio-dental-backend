package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.entity.DepartamentoEntity;
import com.proyecto.consultorio_dental_backend.exception.DepartamentoNoEncontradoException;
import com.proyecto.consultorio_dental_backend.repository.DepartamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    private final Logger log = LoggerFactory.getLogger(DepartamentoServiceImpl.class);
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public DepartamentoEntity findById(Integer id) {
        return departamentoRepository.findById(id)
                .orElseThrow( () -> {
                    log.warn("Cuidado: No se encontró departamento con el id {}", id);
                    return new DepartamentoNoEncontradoException(id);
                });
    }

    @Override
    public List<DepartamentoEntity> findAll() {
        List<DepartamentoEntity> departamentos = departamentoRepository.findAll();
        if (departamentos.isEmpty()) {
            log.warn("La lista de departamentos está vacía");
        } else {
            log.info("Se encontraron {} departamentos", departamentos.size());
        }
        return departamentos;
    }

}
