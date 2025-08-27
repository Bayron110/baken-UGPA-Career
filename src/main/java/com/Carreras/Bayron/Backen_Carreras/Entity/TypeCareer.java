package com.Carreras.Bayron.Backen_Carreras.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeCareer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tipo;

    private Integer duracion;

    @OneToMany(mappedBy = "typeCareer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<CalCareer> calCareers = new ArrayList<>();

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<CalCareer> getCalCareers() {
        return calCareers;
    }

    public void setCalCareers(List<CalCareer> calCareers) {
        this.calCareers = calCareers;
    }
}
