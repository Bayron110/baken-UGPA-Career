package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "careers")
public class Career {

    @Id
    private String id;

    private String nombre;

    @DBRef
    private List<CalCareer> calCareers = new ArrayList<>();

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<CalCareer> getCalCareers() { return calCareers; }
    public void setCalCareers(List<CalCareer> calCareers) { this.calCareers = calCareers; }
}
