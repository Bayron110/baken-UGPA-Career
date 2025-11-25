package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.validation.constraints.Min;
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

    @NotBlank(message = "No puede estar sin Capacitación")
    private String capacitación;

    @NotNull(message = "El numero de horas debe superior a 30")
    @Min(value= 30,message = "El numero de horas debe ser de minimo 30")
    private Integer horas;

    @NotBlank(message = "No puede estar en blanco la duración")
    private String duración;
    @NotBlank(message = "No puede estar sin periodo")
    private String periodo;
    @NotBlank(message = "Es obligatorio que sea de tipo generica o especifica")
    private String tipo;

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

    public String getCapacitación() {
        return capacitación;
    }

    public void setCapacitación(String capacitación) {
        this.capacitación = capacitación;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getDuración() {
        return duración;
    }

    public void setDuración(String duración) {
        this.duración = duración;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}