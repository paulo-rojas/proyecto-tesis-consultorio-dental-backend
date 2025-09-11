package com.proyecto.consultorio_dental_backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DireccionRequestDTO {

    @NotBlank
    private String detalle;

    @NotBlank
    private Integer distritoId;
}