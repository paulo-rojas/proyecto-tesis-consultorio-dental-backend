package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.DireccionDTO;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import org.springframework.stereotype.Service;

@Service
public class DireccionMapper {

    public static DireccionDTO toDTO(DireccionEntity direccionEntity){
        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setDetalle(direccionEntity.getDetalle());
        direccionDTO.setDistrito(direccionEntity.getDistrito().getNombre());
        direccionDTO.setProvincia(direccionEntity.getDistrito().getProvincia().getNombre());
        direccionDTO.setDepartamento(direccionEntity.getDistrito().getProvincia().getDepartamento().getNombre());
        return direccionDTO;
    }
}
