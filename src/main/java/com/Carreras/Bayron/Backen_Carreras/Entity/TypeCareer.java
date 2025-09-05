package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "type_careers")
public class TypeCareer {

    @Id
    private String id;

    private String tipo;
    private Integer duracion;

    @DBRef
    private List<CalCareer> calCareers = new ArrayList<>();

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public List<CalCareer> getCalCareers() { return calCareers; }
    public void setCalCareers(List<CalCareer> calCareers) { this.calCareers = calCareers; }
}
