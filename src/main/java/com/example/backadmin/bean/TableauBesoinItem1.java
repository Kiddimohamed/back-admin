package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class TableauBesoinItem1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String statut;
    private String designation;
    private double quantite;
//    private double pu;
    @ManyToOne
    private Fournisseur fournisseur;
    @ManyToOne
    private ExpressionBesoinItem expressionBesoinItem;


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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public ExpressionBesoinItem getExpressionBesoinItem() {
        return expressionBesoinItem;
    }


    public void setExpressionBesoinItem(ExpressionBesoinItem expressionBesoinItem) {
        this.expressionBesoinItem = expressionBesoinItem;
    }



    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }



}
