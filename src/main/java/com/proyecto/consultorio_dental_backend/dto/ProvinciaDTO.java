package com.proyecto.consultorio_dental_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaDTO {
    private Integer id;
    private String nombre;
    private String departamento;
}
