package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.ProvinciaDTO;
import com.proyecto.consultorio_dental_backend.entity.ProvinciaEntity;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaMapper {

    public static ProvinciaDTO toDTO (ProvinciaEntity provinciaEntity){
        ProvinciaDTO provinciaDTO = new ProvinciaDTO();
        provinciaDTO.setId(provinciaEntity.getId());
        provinciaDTO.setNombre(provinciaDTO.getNombre());
        provinciaDTO.setDepartamento(provinciaEntity.getDepartamento().getNombre());
        return provinciaDTO;
    }
}
