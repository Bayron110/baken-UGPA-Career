package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "docentes")
public class Docente {

    @Id
    private String id;

    @NotBlank(message = "El nombre del docente no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La carrera es obligatoria")
    private String carreraId; // Relación con Career

    @NotNull(message = "La participación es obligatoria")
    private Boolean participacionCapacitacion = false;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarreraId() { return carreraId; }
    public void setCarreraId(String carreraId) { this.carreraId = carreraId; }

    public Boolean getParticipacionCapacitacion() { return participacionCapacitacion; }
    public void setParticipacionCapacitacion(Boolean participacionCapacitacion) {
        this.participacionCapacitacion = participacionCapacitacion;
    }
}