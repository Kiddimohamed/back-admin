package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class ReceptionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceReceptionItem;
    private double quantite;
    private double NumInventaire;
    private String libelle;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Reception reception;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceReceptionItem() {
        return referenceReceptionItem;
    }

    public void setReferenceReceptionItem(String referenceReceptionItem) {
        this.referenceReceptionItem = referenceReceptionItem;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getNumInventaire() {
        return NumInventaire;
    }

    public void setNumInventaire(double numInventaire) {
        NumInventaire = numInventaire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }
}
