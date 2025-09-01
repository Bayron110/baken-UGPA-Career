package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "axles_tsu")
public class AxlesTsu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la combinación específica de carrera + tipo
    @ManyToOne(optional = false)
    @JoinColumn(name = "cal_career_id", nullable = false)
    private CalCareer calCareer;

    @Column(length = 10)
    private String nivel;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje1;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje2;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje3;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje4;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje5;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje6;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public CalCareer getCalCareer() {
        return calCareer;
    }

    public void setCalCareer(CalCareer calCareer) {
        this.calCareer = calCareer;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEje1() {
        return eje1;
    }

    public void setEje1(String eje1) {
        this.eje1 = eje1;
    }

    public String getEje2() {
        return eje2;
    }

    public void setEje2(String eje2) {
        this.eje2 = eje2;
    }

    public String getEje3() {
        return eje3;
    }

    public void setEje3(String eje3) {
        this.eje3 = eje3;
    }

    public String getEje4() {
        return eje4;
    }

    public void setEje4(String eje4) {
        this.eje4 = eje4;
    }

    public String getEje5() {
        return eje5;
    }

    public void setEje5(String eje5) {
        this.eje5 = eje5;
    }

    public String getEje6() {
        return eje6;
    }

    public void setEje6(String eje6) {
        this.eje6 = eje6;
    }
}