package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.request.DireccionRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.DireccionResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import org.springframework.stereotype.Service;

@Service
public class DireccionMapper {

    public static DireccionResponseDTO toDTO(DireccionEntity entity){
        DireccionResponseDTO dto = new DireccionResponseDTO();
        dto.setDetalle(entity.getDetalle());
        dto.setDistrito(entity.getDistrito().getNombre());
        dto.setProvincia(entity.getDistrito().getProvincia().getNombre());
        dto.setDepartamento(entity.getDistrito().getProvincia().getDepartamento().getNombre());
        return dto;
    }

    public static DireccionEntity toEntity(DireccionRequestDTO dto, DistritoEntity distrito) {
        DireccionEntity entity = new DireccionEntity();
        entity.setDetalle(dto.getDetalle());
        entity.setDistrito(distrito);
        return entity;
    }

}
