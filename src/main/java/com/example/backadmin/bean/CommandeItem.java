package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    private double quantite;
    private double prixUHT;
    private double prixTHT;

    @OneToOne
    private Produit produit;

    @ManyToOne
    private Commande commande;


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrixUHT() {
        return prixUHT;
    }

    public void setPrixUHT(double prixUHT) {
        this.prixUHT = prixUHT;
    }

    public double getPrixTHT() {
        return prixTHT;
    }

    public void setPrixTHT(double prixTHT) {
        this.prixTHT = prixTHT;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
