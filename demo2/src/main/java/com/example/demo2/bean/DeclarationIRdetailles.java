package com.example.demo2.bean;

import javax.persistence.*;

@Entity
public class DeclarationIRdetailles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private DeclarationIR declarationIR;
    private Double salaireEmployeNet;
    private Double salaireEmployeBrute;
    private Double montantIR;
    @ManyToOne
    private TauxIR tauxIR;
    @ManyToOne
    private DemandeDeclaration demandeDeclaration;


    public DeclarationIR getDeclarationIR() {
        return declarationIR;
    }

    public void setDeclarationIR(DeclarationIR declarationIR) {
        this.declarationIR = declarationIR;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Double getSalaireEmployeNet() {
        return salaireEmployeNet;
    }

    public void setSalaireEmployeNet(Double salaireEmploye) {
        this.salaireEmployeNet = salaireEmploye;
    }

    public Double getSalaireEmployeBrute() {
        return salaireEmployeBrute;
    }

    public void setSalaireEmployeBrute(Double salaireEmployeBrute) {
        this.salaireEmployeBrute = salaireEmployeBrute;
    }

    public TauxIR getTauxIR() {
        return tauxIR;
    }

    public void setTauxIR(TauxIR tauxIR) {
        this.tauxIR = tauxIR;
    }

    public Double getMontantIR() {
        return montantIR;
    }

    public void setMontantIR(Double montantIR) {
        this.montantIR = montantIR;
    }
}
