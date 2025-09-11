package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.request.MedicoRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseSimpleDTO;
import com.proyecto.consultorio_dental_backend.entity.MedicoEntity;

public class MedicoMapper {

    public static MedicoResponseSimpleDTO toSimpleDTO(MedicoEntity entity){
        MedicoResponseSimpleDTO dto = new MedicoResponseSimpleDTO();
        String nombreCompleto = entity.getApellidoPaterno() + " " + entity.getApellidoMaterno() + " " + entity.getNombres();
        dto.setNombreCompleto(nombreCompleto);
        dto.setId(entity.getId());
        return dto;
    }

    public static MedicoResponseGeneralDTO toGeneralDTO(MedicoEntity entity){
        MedicoResponseGeneralDTO dto = new MedicoResponseGeneralDTO();
        dto.setId(entity.getId());
        dto.setDni(entity.getDni());
        dto.setNombres(entity.getNombres());
        dto.setApellidoMaterno(entity.getApellidoMaterno());

        return null;
    }

    public static MedicoEntity toEntity(MedicoRequestDTO dto) {
        return null;
    }
}
