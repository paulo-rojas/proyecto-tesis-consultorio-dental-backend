package com.proyecto.consultorio_dental_backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.proyecto.consultorio_dental_backend.util.NullAsEmptyStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseGeneralDTO {

    private Integer id;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private Integer edad;

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private ContactoDTO contacto;

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String especialidad;

    @JsonSerialize(nullsUsing = NullAsEmptyStringSerializer.class)
    private String codigoColegiatura;

}
