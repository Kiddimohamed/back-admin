package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExpressionBesoinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantite;
    private String code;
    private String libelle;
    private String statut;
    private String refExpr;
    private double pu ;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ExpressionBesoin expressionBesoin;


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


    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public String getRefExpr() {
        return refExpr;
    }

    public void setRefExpr(String refExpr) {
        this.refExpr = refExpr;
    }


}

