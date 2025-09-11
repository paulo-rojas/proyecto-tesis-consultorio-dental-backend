package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.response.DistritoResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import org.springframework.stereotype.Service;

@Service
public class DistritoMapper {

    public static DistritoResponseDTO toDTO(DistritoEntity distritoEntity){
        DistritoResponseDTO distritoResponseDTO = new DistritoResponseDTO();
        distritoResponseDTO.setId(distritoEntity.getId());
        distritoResponseDTO.setNombre(distritoEntity.getNombre());
        distritoResponseDTO.setProvincia(distritoEntity.getProvincia().getNombre());
        distritoResponseDTO.setDepartamento(distritoEntity.getProvincia().getDepartamento().getNombre());
        return distritoResponseDTO;
    }
}
