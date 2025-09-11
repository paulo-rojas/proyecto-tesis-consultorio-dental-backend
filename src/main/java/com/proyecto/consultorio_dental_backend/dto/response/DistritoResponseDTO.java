package com.proyecto.consultorio_dental_backend.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistritoResponseDTO {
    private Integer id;
    private String nombre;
    private String provincia;
    private String departamento;
}
