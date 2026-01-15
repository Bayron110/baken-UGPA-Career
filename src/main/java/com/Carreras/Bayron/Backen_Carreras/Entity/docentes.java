package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docentes")
public class docentes {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    private String carreraId;

    private Integer secuencia;

    // 🔹 Nuevos campos
    @NotBlank(message = "La cédula no puede estar vacía")
    private String cedula;

    @NotBlank(message = "La formación no puede estar vacía")
    private String formacion; // Ej: "Ingeniería", "Licenciatura"

    private String programa; // Ej: "Maestría en Educación", "Doctorado en Ciencias"

    private String estado;   // Ej: "Cursando", "Finalizado"
    @Indexed(unique = true)
    private String periodo;  // Ej: "2022-2024", "2021-I"

    // ====== Getters y Setters ======

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarreraId() { return carreraId; }
    public void setCarreraId(String carreraId) { this.carreraId = carreraId; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getFormacion() { return formacion; }
    public void setFormacion(String formacion) { this.formacion = formacion; }

    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }
}