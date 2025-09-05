package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Document(collection = "cal_careers")
public class CalCareer {

    @Id
    private String id;

    @DBRef
    private Career career;

    @DBRef
    private TypeCareer typeCareer;

    private LocalDate fechaActual;
    private LocalDate fechaFin;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Career getCareer() { return career; }
    public void setCareer(Career career) { this.career = career; }

    public TypeCareer getTypeCareer() { return typeCareer; }
    public void setTypeCareer(TypeCareer typeCareer) { this.typeCareer = typeCareer; }

    public LocalDate getFechaActual() { return fechaActual; }
    public void setFechaActual(LocalDate fechaActual) { this.fechaActual = fechaActual; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
