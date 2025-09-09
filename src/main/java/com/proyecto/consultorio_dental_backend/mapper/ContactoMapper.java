package com.proyecto.consultorio_dental_backend.mapper;

import com.proyecto.consultorio_dental_backend.dto.ContactoDTO;
import com.proyecto.consultorio_dental_backend.entity.ContactoEntity;
import com.proyecto.consultorio_dental_backend.entity.DireccionEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactoMapper {

    public static ContactoDTO toDTO(ContactoEntity entity){
        ContactoDTO dto = new ContactoDTO();
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono1(entity.getTelefono1());
        dto.setTelefono2(entity.getTelefono2());
        return dto;
    }

    public static ContactoEntity toEntity(ContactoDTO contactoDTO) {
        ContactoEntity entity = new ContactoEntity();
        entity.setCorreo(contactoDTO.getCorreo());
        entity.setTelefono1(contactoDTO.getTelefono1());
        entity.setTelefono2(contactoDTO.getTelefono2());
        return entity;
    }

    /*

    public static ContactoEntity toEntity(ContactoDTO dto) {
        DireccionEntity entity = new DireccionEntity();
        entity.setDetalle(dto.getDetalle());
        entity.setDistrito(distrito);
        return entity;
    }


     */
}
