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
    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contacto_id", referencedColumnName = "id")
    private ContactoEntity contacto;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionEntity direccion;

    // MANTENER LOS DATOS QUE INGRESEN EN MAYÚSCULAS
    public void setNombres(String nombres) {
        this.nombres = (nombres != null) ? nombres.toUpperCase() : null;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = (apellidoPaterno != null) ? apellidoPaterno.toUpperCase() : null;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = (apellidoMaterno != null) ? apellidoMaterno.toUpperCase() : null;
    }
}
