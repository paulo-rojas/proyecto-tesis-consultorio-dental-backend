package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PacienteMapper {

    private static final Logger log = LoggerFactory.getLogger(PacienteMapper.class);

    public static PacienteDTO toDTO (PacienteEntity entity){
        PacienteDTO dto = new PacienteDTO();
        dto.setId(entity.getId());
        dto.setDni(entity.getDni());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setEdad(CommonUtils.calcularEdad(dto.getFechaNacimiento()));
        dto.setTelefono1(entity.getTelefono1());
        dto.setTelefono2(entity.getTelefono2());
        dto.setCantidadReferidos(entity.getCantidadReferidos());
        dto.setOcupacion(entity.getOcupacion());

        if (entity.getDireccion() != null){
            dto.setDireccion(DireccionMapper.toDTO(entity.getDireccion()));
        } else {
            dto.setDireccion(null);
            log.warn("Paciente con id {} no cuenta con dirección", entity.getId());
        }

        return dto;
    }

    public static PacienteEntity toEntity(PacienteDTO paciente) {

        return null;
    }
}
