package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

@Document(collection = "cal_careers")
public class CalCareer {

    @Id
    private String id;

    @DBRef
    @NotNull(message = "La carrera no puede ser nula")
    private Career career;

    @DBRef
    @NotNull(message = "El tipo de carrera no puede ser nulo")
    private TypeCareer typeCareer;

    @NotNull(message = "La fecha actual no puede ser nula")
    @PastOrPresent(message = "La fecha actual debe ser hoy o anterior")
    private LocalDate fechaActual;

    @NotNull(message = "La fecha de finalización no puede ser nula")
    @FutureOrPresent(message = "La fecha de finalización debe ser hoy o posterior")
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