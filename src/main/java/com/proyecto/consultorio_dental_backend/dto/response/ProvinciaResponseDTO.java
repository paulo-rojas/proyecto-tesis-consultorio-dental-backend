package com.proyecto.consultorio_dental_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaResponseDTO {
    private Integer id;
    private String nombre;
    private String departamento;
}
