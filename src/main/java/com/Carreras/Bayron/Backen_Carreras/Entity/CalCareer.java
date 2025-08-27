package com.Carreras.Bayron.Backen_Carreras.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CalCareer")
public class CalCareer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "career_id", nullable = false)
    private Career career;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_career_id", nullable = false)
    private TypeCareer typeCareer;

    @Column(name = "fecha_actual", nullable = false)
    private LocalDate fechaActual;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public CalCareer() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Career getCareer() { return career; }
    public void setCareer(Career career) { this.career = career; }
    public TypeCareer getTypeCareer() { return typeCareer; }
    public void setTypeCareer(TypeCareer typeCareer) { this.typeCareer = typeCareer; }
    public LocalDate getFechaActual() { return fechaActual; }
    public void setFechaActual(LocalDate fechaActual) { this.fechaActual = fechaActual; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
