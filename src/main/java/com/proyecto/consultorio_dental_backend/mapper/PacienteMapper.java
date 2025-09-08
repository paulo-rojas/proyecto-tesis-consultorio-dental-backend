package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PacienteMapper {

    private static final Logger log = LoggerFactory.getLogger(PacienteMapper.class);

    public static PacienteDTO toDTO (PacienteEntity entity){
        if (entity == null) {
            return null;
        }
        
        PacienteDTO dto = new PacienteDTO();
        
        // Campos heredados de PersonaEntity
        dto.setId(entity.getId());
        dto.setDni(entity.getDni());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setEdad(CommonUtils.calcularEdad(entity.getFechaNacimiento())); // Corregido
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono1(entity.getTelefono1());
        dto.setTelefono2(entity.getTelefono2());
        dto.setEstado(entity.getEstado());

        // Campos propios de PacienteEntity
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

    public static PacienteEntity toEntity(PacienteDTO dto) {
        if (dto == null) {
            return null;
        }

        PacienteEntity entity = new PacienteEntity();

        // Campos heredados de PersonaEntity
        // El ID no se setea desde el DTO, ya que es autogenerado o se maneja en el servicio para actualizaciones.
        entity.setDni(dto.getDni());
        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono1(dto.getTelefono1());
        entity.setTelefono2(dto.getTelefono2());
        entity.setEstado(dto.getEstado());

        // Campos propios de PacienteEntity
        entity.setCantidadReferidos(dto.getCantidadReferidos());
        entity.setOcupacion(dto.getOcupacion());

        // La entidad Direccion no se mapea aquí. La lógica de asociación
        // (crear/asignar una DireccionEntity) debe manejarse en la capa de servicio.

        return entity;
    }
}
