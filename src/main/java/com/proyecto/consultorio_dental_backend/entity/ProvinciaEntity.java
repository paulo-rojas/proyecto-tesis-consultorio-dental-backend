package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provincia")
public class ProvinciaEntity {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id") // nombre de la columna en la tabla 'provincia'
    private DepartamentoEntity departamento;

}
