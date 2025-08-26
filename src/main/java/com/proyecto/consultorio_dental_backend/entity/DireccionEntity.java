package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class DireccionEntity {

    @Id
    private Integer id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "distrito_id" )
    private DistritoEntity distrito;

    public DireccionEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DistritoEntity getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoEntity distrito) {
        this.distrito = distrito;
    }
}
