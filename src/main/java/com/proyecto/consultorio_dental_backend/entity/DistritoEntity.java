package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distrito")
public class DistritoEntity {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "provincia_id" )
    private ProvinciaEntity provincia;

    public DistritoEntity(){
    }


    public DistritoEntity(String nombre){
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaEntity getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEntity provincia) {
        this.provincia = provincia;
    }
}
