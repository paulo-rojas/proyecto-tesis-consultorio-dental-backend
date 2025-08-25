package com.proyecto.consultorio_dental_backend.dto;

public class DistritoDTO {

    private Integer id;
    private String nombre;

    public DistritoDTO(){

    }

    public DistritoDTO(Integer id, String nombre) {
        this.id = id;
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
