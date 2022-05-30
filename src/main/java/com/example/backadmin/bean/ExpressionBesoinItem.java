package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExpressionBesoinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantite;
    private String code;
    private String libelle;
    private String statut;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ExpressionBesoin expressionBesoin;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Fournisseur fournisseur;

    @ManyToOne
    private Produit produit;


    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public ExpressionBesoin getExpressionBesoin() {
        return expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExpressionBesoin getExpressionBesoins() {
        return expressionBesoin;
    }

    public void setExpressionBesoins(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}

