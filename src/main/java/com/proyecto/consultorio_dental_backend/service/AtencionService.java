package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.AtencionDTO;

import java.util.List;

public interface AtencionService {

    AtencionDTO findById (Integer atencionId);

    List<AtencionDTO> findAll();

    AtencionDTO save(AtencionDTO atencionDto);

}
