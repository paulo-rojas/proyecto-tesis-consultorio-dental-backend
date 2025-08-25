package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.DistritoDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import org.springframework.stereotype.Service;

@Service
public class DistritoMapper {

    public static DistritoDTO toDTO(DistritoEntity distritoEntity){
        DistritoDTO distritoDTO = new DistritoDTO();
        distritoDTO.setId(distritoEntity.getId());
        distritoDTO.setNombre(distritoDTO.getNombre());
        return distritoDTO;
    }
}
