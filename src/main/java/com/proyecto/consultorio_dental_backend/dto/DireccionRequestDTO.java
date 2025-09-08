package com.proyecto.consultorio_dental_backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DireccionRequestDTO {
    private String detalle;
    private Integer distritoId;
}