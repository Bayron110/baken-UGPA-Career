package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "docentes")
public class docentes {

    @Id
    private String id;

    @NotBlank
    @Size(min = 5, max = 120)
    private String nombresCompletos;

    @NotBlank
    @Indexed(unique = true)
    @Size(min = 10, max = 10)
    private String cedula;

    @NotBlank
    private String formacionActual;

    @NotBlank
    private String nivel;

    @NotBlank
    private String universidad;

    @NotBlank
    private String estado; // En curso / Finalizado

    @NotBlank
    private String periodo; // Ej: 2018-2022

    // 🔥 RELACIÓN CON CARRERA
    @NotBlank
    private String careerId;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombresCompletos() { return nombresCompletos; }
    public void setNombresCompletos(String nombresCompletos) { this.nombresCompletos = nombresCompletos; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getFormacionActual() { return formacionActual; }
    public void setFormacionActual(String formacionActual) { this.formacionActual = formacionActual; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public String getCareerId() { return careerId; }
    public void setCareerId(String careerId) { this.careerId = careerId; }
}
