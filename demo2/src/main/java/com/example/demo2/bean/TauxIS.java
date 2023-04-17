package com.example.demo2.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TauxIS {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;
    private double resultatFiscalMin;
    private double resultatFiscalMax;
    private double pourcentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getResultatFiscalMin() {
        return resultatFiscalMin;
    }

    public void setResultatFiscalMin(double resultatFiscalMin) {
        this.resultatFiscalMin = resultatFiscalMin;
    }

    public double getResultatFiscalMax() {
        return resultatFiscalMax;
    }

    public void setResultatFiscalMax(double resultatFiscalMax) {
        this.resultatFiscalMax = resultatFiscalMax;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
}
