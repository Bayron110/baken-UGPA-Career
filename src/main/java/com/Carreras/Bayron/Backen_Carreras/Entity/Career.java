package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "careers")
public class Career {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 1000, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "La lista de calificaciones no puede ser nula")
    private List<@NotNull CalCareer> calCareers = new ArrayList<>();

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CalCareer> getCalCareers() {
        return calCareers;
    }

    public void setCalCareers(List<CalCareer> calCareers) {
        this.calCareers = calCareers;
    }
}