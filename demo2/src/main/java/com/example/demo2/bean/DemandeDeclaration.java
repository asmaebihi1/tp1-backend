package com.example.demo2.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class DemandeDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeclaration;
    private Double totalPaye;
    private Double total;
    private Double totalEsps;
    private Double totalNonEsps;

    @ManyToOne
    private CategorieDeclaration categorieDeclaration;
    @ManyToOne
    private Comptable comptableDeclarant;
    @ManyToOne
    private Comptable comptableVerifiant;
    @ManyToOne
    private Societe Societe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public CategorieDeclaration getCategorieDeclaration() {
        return categorieDeclaration;
    }

    public void setCategorieDeclaration(CategorieDeclaration categorieDeclaration) {
        this.categorieDeclaration = categorieDeclaration;
    }

    public Comptable getComptableDeclarant() {
        return comptableDeclarant;
    }

    public void setComptableDeclarant(Comptable comptableDeclarant) {
        this.comptableDeclarant = comptableDeclarant;
    }

    public Comptable getComptableVerifiant() {
        return comptableVerifiant;
    }

    public void setComptableVerifiant(Comptable comptableVerifiant) {
        this.comptableVerifiant = comptableVerifiant;
    }

    public com.example.demo2.bean.Societe getSociete() {
        return Societe;
    }

    public void setSociete(com.example.demo2.bean.Societe societe) {
        Societe = societe;
    }

    public Double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(Double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setEtatDeclaration(EtatDeclaration newEtatDeclaration) {
    }

    public Double getTotalEsps() {
        return totalEsps;
    }

    public void setTotalEsps(Double totalEsps) {
        this.totalEsps = totalEsps;
    }

    public Double getTotalNonEsps() {
        return totalNonEsps;
    }

    public void setTotalNonEsps(Double totalNonEsps) {
        this.totalNonEsps = totalNonEsps;
    }
}
