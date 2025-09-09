package com.proyecto.consultorio_dental_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDTO {

        private Integer id;
        private String dni;
        private String nombres;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private LocalDate fechaNacimiento;
        private Integer edad;
        private ContactoDTO contacto;
        private String ocupacion;
        private DireccionResponseDTO direccion;

}
