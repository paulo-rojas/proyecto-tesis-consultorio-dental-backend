package com.proyecto.consultorio_dental_backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCita {

    PENDIENTE("Pendiente"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado"),
    COMPLETADO("Completado"),
    REPROGRAMADO("Reprogramado"),
    NO_ASISTIO("No asistió");

    private final String displayName;

    EstadoCita(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName(){
        return displayName;
    }
}
