package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "docentes")
public class Docente {

    @Id
    private String id;

    @NotBlank(message = "Los nombres completos son obligatorios")
    @Size(min = 5, max = 150)
    private String nombresCompletos;

    @NotBlank(message = "La cédula es obligatoria")
    @Indexed(unique = true)
    private String cedula;

    @NotBlank(message = "La formación es obligatoria")
    private String formacion;

    @NotBlank(message = "La carrera es obligatoria")
    private String careerId; // RELACIÓN CON Career

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombresCompletos() { return nombresCompletos; }
    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getFormacion() { return formacion; }
    public void setFormacion(String formacion) { this.formacion = formacion; }

    public String getCareerId() { return careerId; }
    public void setCareerId(String careerId) { this.careerId = careerId; }
}
