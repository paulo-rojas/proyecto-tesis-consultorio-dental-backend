package com.proyecto.consultorio_dental_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistritoDTO {

    private Integer id;
    private String nombre;
    private String provincia;
    private String departamento;
}
