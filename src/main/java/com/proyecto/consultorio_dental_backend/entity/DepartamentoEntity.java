package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    private Integer id;
    private String nombre;

    public DepartamentoEntity(){

    }

    public DepartamentoEntity(String nombre){
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
}
