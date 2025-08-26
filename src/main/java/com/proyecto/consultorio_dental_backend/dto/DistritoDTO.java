package com.proyecto.consultorio_dental_backend.dto;

public class DistritoDTO {

    private Integer id;
    private String nombre;
    private String provincia;
    private String departamento;

    public DistritoDTO(){

    }

    public DistritoDTO(Integer id, String nombre, String provincia, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.departamento = departamento;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
