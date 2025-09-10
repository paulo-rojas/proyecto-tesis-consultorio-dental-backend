package com.proyecto.consultorio_dental_backend.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {

    @NotBlank(message = "El DNI no puede estar vacío.")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres.")
    private String dni;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombres;

    @NotBlank(message = "El apellido paterno no puede estar vacío.")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno no puede estar vacío.")
    private String apellidoMaterno;

    @NotNull(message = "La fecha de nacimiento no puede ser nula.")
    @Past(message = "La fecha de nacimiento debe ser una fecha en el pasado.")
    private LocalDate fechaNacimiento;

    @Valid
    private ContactoDTO contacto;

    private String ocupacion;

}
