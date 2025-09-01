package com.Carreras.Bayron.Backen_Carreras.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "axles_superior")
public class AxlesSuperior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "cal_career_id", nullable = false)
    private CalCareer calCareer;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje1;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje2;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje3;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String eje4;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String nivel;


    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

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
}