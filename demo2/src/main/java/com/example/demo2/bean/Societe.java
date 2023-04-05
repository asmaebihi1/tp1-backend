package com.example.demo2.bean;

import javax.persistence.*;

@Entity
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ice;
    private String libelle;
    @ManyToOne
    private CategorieSociete categorieSociete;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public CategorieSociete getCategorieSociete() {
        return categorieSociete;
    }

    public void setCategorieSociete(CategorieSociete categorieSociete) {
        this.categorieSociete = categorieSociete;
    }
}
