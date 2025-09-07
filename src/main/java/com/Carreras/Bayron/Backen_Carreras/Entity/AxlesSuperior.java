package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Document(collection = "axles_superior")
public class AxlesSuperior {

    @Id
    private String id;

    @DBRef
    @NotNull(message = "La referencia a CalCareer no puede ser nula")
    private CalCareer calCareer;

    @NotBlank(message = "Eje 1 no puede estar vacío")
    @Size(min = 3, max = 10000, message = "Eje 1 debe tener entre 3 y 100 caracteres")
    private String eje1;

    @NotBlank(message = "Eje 2 no puede estar vacío")
    @Size(min = 3, max = 10000, message = "Eje 2 debe tener entre 3 y 100 caracteres")
    private String eje2;

    @NotBlank(message = "Eje 3 no puede estar vacío")
    @Size(min = 3, max = 10000, message = "Eje 3 debe tener entre 3 y 100 caracteres")
    private String eje3;

    @NotBlank(message = "Eje 4 no puede estar vacío")
    @Size(min = 3, max = 10000, message = "Eje 4 debe tener entre 3 y 100 caracteres")
    private String eje4;

    @NotBlank(message = "El nivel no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nivel debe tener entre 2 y 50 caracteres")
    private String nivel;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public CalCareer getCalCareer() { return calCareer; }
    public void setCalCareer(CalCareer calCareer) { this.calCareer = calCareer; }

    public String getEje1() { return eje1; }
    public void setEje1(String eje1) { this.eje1 = eje1; }

    public String getEje2() { return eje2; }
    public void setEje2(String eje2) { this.eje2 = eje2; }

    public String getEje3() { return eje3; }
    public void setEje3(String eje3) { this.eje3 = eje3; }

    public String getEje4() { return eje4; }
    public void setEje4(String eje4) { this.eje4 = eje4; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}