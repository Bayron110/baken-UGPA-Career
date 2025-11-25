package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Docentes")
public class Docente {


    @Id
    private String id;

    @NotBlank(message = "Ingrese el Nombre del docente")
    private String nombre;

    @NotBlank(message = "Ingrese el numero de cedula que corresponda")
    private String cedula;

    @NotBlank(message = "Ingrese una capacitación")
    private String capacitación;

    @NotBlank(message = "Ingrese el numero de cedula que corresponda")
    private String codigo;

    @DBRef
    private Career carrera;

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Career getCarrera() {
        return carrera;
    }

    public void setCarrera(Career carrera) {
        this.carrera = carrera;
    }
}
