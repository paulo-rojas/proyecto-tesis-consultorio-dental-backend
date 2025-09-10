package com.proyecto.consultorio_dental_backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.proyecto.consultorio_dental_backend.util.NullAsEmptyStringSerializer;
import lombok.Data;

@Data
public class ContactoDTO {

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String telefono1;

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String telefono2;

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String correo;
}
