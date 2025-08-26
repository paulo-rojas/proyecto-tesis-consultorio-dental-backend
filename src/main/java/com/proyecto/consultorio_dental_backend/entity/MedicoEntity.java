package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medico")
public class MedicoEntity {

    @Id
    private Integer id;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String codigoColegiatura;

    @OneToOne
    @JoinColumn(name = "direccion_id" )
    private DireccionEntity direccion;
}
