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
@Table(name = "direcciones")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String detalle;

    @ManyToOne
    @JoinColumn(name = "distrito_id" )
    private DistritoEntity distrito;

    public void setDetalle(String detalle) {
        this.detalle = (detalle != null) ? detalle.toUpperCase() : null;
    }
}
