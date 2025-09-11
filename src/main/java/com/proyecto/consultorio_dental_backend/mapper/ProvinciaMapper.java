package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.response.ProvinciaResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.ProvinciaEntity;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaMapper {

    public static ProvinciaResponseDTO toDTO (ProvinciaEntity provinciaEntity){
        ProvinciaResponseDTO provinciaResponseDTO = new ProvinciaResponseDTO();
        provinciaResponseDTO.setId(provinciaEntity.getId());
        provinciaResponseDTO.setNombre(provinciaResponseDTO.getNombre());
        provinciaResponseDTO.setDepartamento(provinciaEntity.getDepartamento().getNombre());
        return provinciaResponseDTO;
    }
}
