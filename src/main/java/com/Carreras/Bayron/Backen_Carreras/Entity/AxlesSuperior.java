package com.Carreras.Bayron.Backen_Carreras.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "axles_superior")
public class AxlesSuperior {

    @Id
    private String id;

    @DBRef
    private CalCareer calCareer;

    private String eje1;
    private String eje2;
    private String eje3;
    private String eje4;
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
