package com.proyecto.consultorio_dental_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AtencionDTO {

    @NotBlank
    private Integer id;
    @NotBlank
    private String atencion;
}
