package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "docentes")
public class Docente {

    @Id
    private String id;

    @NotBlank(message = "El nombre del docente es obligatorio")
    private String nombre;

    @NotBlank(message = "La carrera es obligatoria")
    private String carreraId;

    @NotBlank(message = "La formación es obligatoria")
    private String formacion;

    @NotBlank(message = "La cédula es obligatoria")
    @Indexed(unique = true)
    private String cedula;

    // GETTERS & SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarreraId() { return carreraId; }
    public void setCarreraId(String carreraId) { this.carreraId = carreraId; }

    public String getFormacion() { return formacion; }
    public void setFormacion(String formacion) { this.formacion = formacion; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
}
