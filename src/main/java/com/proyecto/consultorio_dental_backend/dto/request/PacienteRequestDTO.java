package com.proyecto.consultorio_dental_backend.dto.request;


import com.proyecto.consultorio_dental_backend.dto.ContactoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*
 * DTO para manejar la solicitud de creación de un nuevo paciente.
 * Contiene solo los campos necesarios que el cliente debe proporcionar.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {

    /**
     * Número de Documento Nacional de Identidad del paciente.
     * Debe ser único y contener exactamente 8 dígitos.
     */
    @NotBlank
    private String dni;

    /**
     * Nombres del paciente.
     */
    @NotBlank
    private String nombres;

    /**
     * Apellido paterno del paciente.
     */
    @NotBlank
    private String apellidoPaterno;

    /**
     * Apellido materno del paciente.
     */
    @NotBlank
    private String apellidoMaterno;

    /**
     * Fecha de nacimiento del paciente.
     * Debe ser una fecha en el pasado.
     */
    @NotNull
    @Past
    private LocalDate fechaNacimiento;

    /**
     * Información de contacto opcional del paciente (teléfonos, correo).
     * Si se proporciona, se validarán sus campos internos.
     */
    @Valid
    private ContactoDTO contacto;

    /**
     * Ocupación opcional del paciente.
     */
    private String ocupacion;

}
