package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.PacienteRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.PacienteResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PacienteMapper {

    private static final Logger log = LoggerFactory.getLogger(PacienteMapper.class);

    public static PacienteResponseDTO toDTO (PacienteEntity entity){

        PacienteResponseDTO dto = new PacienteResponseDTO();

        dto.setId(entity.getId());
        dto.setDni(entity.getDni());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setEdad(CommonUtils.calcularEdad(entity.getFechaNacimiento())); // Corregido

        if (entity.getContacto() != null){
            dto.setContacto(ContactoMapper.toDTO(entity.getContacto()));
        } else {
            dto.setDireccion(null);
            log.warn("Paciente con id {} no cuenta con contacto", entity.getId());
        }

        dto.setOcupacion(entity.getOcupacion());

        if (entity.getDireccion() != null){
            dto.setDireccion(DireccionMapper.toDTO(entity.getDireccion()));
        } else {
            dto.setDireccion(null);
            log.warn("Paciente con id {} no cuenta con dirección", entity.getId());
        }

        return dto;
    }

    public static PacienteEntity toEntity(PacienteRequestDTO dto) {

        PacienteEntity entity = new PacienteEntity();

        entity.setDni(dto.getDni());
        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setEstado(true);
        entity.setContacto(null);
        entity.setOcupacion(dto.getOcupacion());
        return entity;
    }
}
