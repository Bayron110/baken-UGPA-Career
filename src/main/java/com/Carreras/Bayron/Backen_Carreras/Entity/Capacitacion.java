package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Capacitacion {

    @NotBlank(message = "El nombre de la capacitación no puede estar vacío")
    private String nombre;

    @NotNull(message = "Las horas son obligatorias")
    @Min(value = 1, message = "Las horas deben ser mínimo 1")
    private Integer horas;

    @NotBlank(message = "La duración es obligatoria")
    private String duracion;

    @NotBlank(message = "El periodo es obligatorio")
    private String periodo;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
