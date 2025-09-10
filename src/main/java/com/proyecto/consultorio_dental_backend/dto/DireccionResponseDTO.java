package com.proyecto.consultorio_dental_backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.proyecto.consultorio_dental_backend.util.NullAsEmptyStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionResponseDTO {

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String detalle;

    private String distrito;
    private String provincia;
    private String departamento;
}
