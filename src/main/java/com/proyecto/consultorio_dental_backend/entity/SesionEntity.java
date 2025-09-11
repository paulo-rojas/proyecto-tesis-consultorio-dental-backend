package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sesiones")
public class SesionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id")
    private CitaEntity cita;

    private String prescripcion;


}
