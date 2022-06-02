package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class NaturePrestationType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String libelle;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<NaturePrestation> naturePrestationList;

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

    public List<NaturePrestation> getNaturePrestationList() {
        return naturePrestationList;
    }

    public void setNaturePrestationList(List<NaturePrestation> naturePrestationList) {
        this.naturePrestationList = naturePrestationList;
    }
}
