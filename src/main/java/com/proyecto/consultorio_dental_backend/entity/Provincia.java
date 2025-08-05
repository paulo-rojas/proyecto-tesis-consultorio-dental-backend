package com.proyecto.consultorio_dental_backend.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Provincia {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id") // nombre de la columna en la tabla 'provincia'
    private Departamento departamento;


    public Provincia (){

    }

    public Provincia (Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Provincia (String nombre){
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
