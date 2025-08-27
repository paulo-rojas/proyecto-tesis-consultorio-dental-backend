package com.proyecto.consultorio_dental_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

    private String detalle;
    private String distrito;
    private String provincia;
    private String departamento;
}
