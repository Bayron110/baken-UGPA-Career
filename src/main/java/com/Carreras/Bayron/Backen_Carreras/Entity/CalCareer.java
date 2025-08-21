package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.persistence.*;

@Entity
public class CalCareer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TypeCareer_Tipo", length = 45)
    private String typeCareerTipo;

    @Column(name = "TypeCareer_Duracion(Semanas)", length = 45)
    private String typeCareerDuracion;

    @Column(name = "Career_id")
    private Integer careerId;

    @Column(name = "fecha_actual", length = 45)
    private String fechaActual;

    @Column(name = "fecha_final", length = 45)
    private String fechaFinal;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCareerTipo() {
        return typeCareerTipo;
    }

    public void setTypeCareerTipo(String typeCareerTipo) {
        this.typeCareerTipo = typeCareerTipo;
    }

    public String getTypeCareerDuracion() {
        return typeCareerDuracion;
    }

    public void setTypeCareerDuracion(String typeCareerDuracion) {
        this.typeCareerDuracion = typeCareerDuracion;
    }

    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}