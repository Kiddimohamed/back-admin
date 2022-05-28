package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class NaturePrestation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String libelle;
    private String libelleType;
    @ManyToOne
    private TypeNaturePrestation typeNaturePrestation;
    //todo report Commande Modify L empllacement de total

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

    public TypeNaturePrestation getTypeNaturePrestation() {
        return typeNaturePrestation;
    }

    public void setTypeNaturePrestation(TypeNaturePrestation typeNaturePrestation) {
        this.typeNaturePrestation = typeNaturePrestation;

    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }
}

