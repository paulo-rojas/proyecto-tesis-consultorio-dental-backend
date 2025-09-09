package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class PacienteEntity extends PersonaEntity {

    private Integer cantidadReferidos;
    private String ocupacion;

}
