package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.PacienteDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;


public class PacienteMapper {

    public static PacienteDTO toDTO (PacienteEntity pacienteEntity){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(pacienteEntity.getId());
        pacienteDTO.setDni(pacienteEntity.getDni());
        pacienteDTO.setNombres(pacienteEntity.getNombres());
        pacienteDTO.setApellidoPaterno(pacienteEntity.getApellidoPaterno());
        pacienteDTO.setApellidoMaterno(pacienteEntity.getApellidoMaterno());
        pacienteDTO.setFechaNacimiento(pacienteEntity.getFechaNacimiento());
        pacienteDTO.setEdad(CommonUtils.calcularEdad(pacienteDTO.getFechaNacimiento()));
        pacienteDTO.setTelefono1(pacienteEntity.getTelefono1());
        pacienteDTO.setTelefono2(pacienteEntity.getTelefono2());
        pacienteDTO.setCantidadReferidos(pacienteEntity.getCantidadReferidos());
        pacienteDTO.setOcupacion(pacienteEntity.getOcupacion());
        pacienteDTO.setDireccion(DireccionMapper.toDTO(pacienteEntity.getDireccion()));
        return pacienteDTO;
    }

    public static PacienteEntity toEntity(PacienteDTO paciente) {

        return null;
    }
}
