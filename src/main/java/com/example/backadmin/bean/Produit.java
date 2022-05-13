package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String numeroInventaire;
    private String libelle;
    private String description;
    private String prixUnitaire;


    @OneToMany(mappedBy = "expressionBesoin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ExpressionBesoinItem> expressionBesoinItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getNumeroInventaire() {
        return numeroInventaire;
    }

    public void setNumeroInventaire(String numeroInventaire) {
        this.numeroInventaire = numeroInventaire;
    }

    public List<ExpressionBesoinItem> getExpressionBesoinItems() {
        return expressionBesoinItems;
    }

    public void setExpressionBesoinItems(List<ExpressionBesoinItem> expressionBesoinItems) {
        this.expressionBesoinItems = expressionBesoinItems;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
