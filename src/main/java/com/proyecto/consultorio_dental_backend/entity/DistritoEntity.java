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
@Table(name = "distrito")
public class DistritoEntity {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "provincia_id" )
    private ProvinciaEntity provincia;

}
