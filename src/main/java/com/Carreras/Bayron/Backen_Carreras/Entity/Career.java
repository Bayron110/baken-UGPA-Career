package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

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

    // ⭐ CAMBIO: De String a List<String>
    @NotNull(message = "La lista de capacitaciones no puede ser nula")
    @NotEmpty(message = "Debe tener al menos una capacitación")
    private List<String> capacitaciones = new ArrayList<>();

    @NotNull(message = "El número de horas debe ser superior a 30")
    @Min(value = 30, message = "El número de horas debe ser de mínimo 30")
    private Integer horas;

    @NotBlank(message = "No puede estar en blanco la duración")
    private String duracion;

    @NotBlank(message = "No puede estar sin periodo")
    private String periodo;

    @NotBlank(message = "Es obligatorio que sea de tipo genérica o específica")
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

    // ⭐ NUEVO: Getter y Setter para List<String>
    public List<String> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<String> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
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

    public List<CalCareer> getCalCareers() {
        return calCareers;
    }

    public void setCalCareers(List<CalCareer> calCareers) {
        this.calCareers = calCareers;
    }
}