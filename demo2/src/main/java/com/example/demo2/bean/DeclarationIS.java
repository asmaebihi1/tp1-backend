package com.example.demo2.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DeclarationIS {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date annee;
    private double totalHTGain;
    private double totalHTCharge;
    private double totalHTDiff;
    private double montantISCalcule;
    private double montantISPaye;
    @ManyToOne
    private Societe societe;
    @OneToOne
    private TauxIS tauxIS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public double getTotalHTGain() {
        return totalHTGain;
    }

    public void setTotalHTGain(double totalHTGain) {
        this.totalHTGain = totalHTGain;
    }

    public double getTotalHTCharge() {
        return totalHTCharge;
    }

    public void setTotalHTCharge(double totalHTCharge) {
        this.totalHTCharge = totalHTCharge;
    }

    public double getTotalHTDiff() {
        return totalHTDiff;
    }

    public void setTotalHTDiff(double totalHTDiff) {
        this.totalHTDiff = totalHTDiff;
    }

    public double getMontantISCalcule() {
        return montantISCalcule;
    }

    public void setMontantISCalcule(double montantISCalcule) {
        this.montantISCalcule = montantISCalcule;
    }

    public double getMontantISPaye() {
        return montantISPaye;
    }

    public void setMontantISPaye(double montantISPaye) {
        this.montantISPaye = montantISPaye;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TauxIS getTauxIS() {
        return tauxIS;
    }

    public void setTauxIS(TauxIS tauxIS) {
        this.tauxIS = tauxIS;
    }
}
