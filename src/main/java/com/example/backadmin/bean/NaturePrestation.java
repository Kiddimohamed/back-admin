package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class NaturePrestation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String code;
    private String libelle;
    private String libelleType;

    @ManyToOne
    private NaturePrestationType naturePrestationType;

    //todo report Commande Modify L emplacement de total

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public NaturePrestationType getNaturePrestationType() {
        return naturePrestationType;
    }

    public void setNaturePrestationType(NaturePrestationType naturePrestationType) {
        this.naturePrestationType = naturePrestationType;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }
}

