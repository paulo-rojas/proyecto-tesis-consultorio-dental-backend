package com.proyecto.consultorio_dental_backend.dto;

public class DistritoDTO {

    private Integer id;
    private String nombre;
    private String provincia;

    public DistritoDTO(){

    }

    public DistritoDTO(Integer id, String nombre, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
