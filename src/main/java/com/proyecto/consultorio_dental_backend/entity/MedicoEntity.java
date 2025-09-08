package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicos")
public class MedicoEntity extends PersonaEntity {

    private String especialidad;
    private String codigoColegiatura;

}
