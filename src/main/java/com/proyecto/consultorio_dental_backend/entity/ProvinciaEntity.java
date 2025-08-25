package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ProvinciaEntity {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id") // nombre de la columna en la tabla 'provincia'
    private DepartamentoEntity departamento;


    public ProvinciaEntity(){

    }

    public ProvinciaEntity(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public ProvinciaEntity(String nombre){
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

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }
}
