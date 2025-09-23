package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "type_careers")
public class TypeCareer {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "El tipo no puede estar vacío")
    @Size(min = 1, max = 50, message = "El tipo debe tener entre 1 y 50 caracteres")
    private String tipo;

    @NotNull(message = "La duración no puede ser nula")
    @Min(value = 1, message = "La duración debe ser al menos de 1 semestre")
    @Max(value = 20, message = "La duración no puede exceder los 20 semestres")
    private Integer duracion;

    @NotNull(message = "La lista de calificaciones no puede ser nula")
    private List<@NotNull CalCareer> calCareers = new ArrayList<>();

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public List<CalCareer> getCalCareers() { return calCareers; }
    public void setCalCareers(List<CalCareer> calCareers) { this.calCareers = calCareers; }
}