package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
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
