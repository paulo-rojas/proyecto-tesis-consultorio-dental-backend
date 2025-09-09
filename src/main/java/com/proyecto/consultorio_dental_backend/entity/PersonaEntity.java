package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono1;
    private String telefono2;
    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contacto_id", referencedColumnName = "id")
    private ContactoEntity contacto;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionEntity direccion;
}
