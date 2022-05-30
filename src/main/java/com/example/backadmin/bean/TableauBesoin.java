package com.example.backadmin.bean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TableauBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private double tva;
    private double ttc;
    private double ht;
    private LocalDateTime dateTableauBesoin;

    @OneToMany
    private List<Fournisseur> fournisseurs;
    @OneToMany
    private List<ExpressionBesoinItem> expressionBesoinItems;

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

    public List<ExpressionBesoinItem> getExpressionBesoinItems() {
        return expressionBesoinItems;
    }

    public void setExpressionBesoinItems(List<ExpressionBesoinItem> expressionBesoinItems) {
        this.expressionBesoinItems = expressionBesoinItems;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public double getTtc() {
        return ttc;
    }

    public void setTtc(double ttc) {
        this.ttc = ttc;
    }

    public double getHt() {
        return ht;
    }

    public void setHt(double ht) {
        this.ht = ht;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public LocalDateTime getDateTableauBesoin() {
        return dateTableauBesoin;
    }

    public void setDateTableauBesoin(LocalDateTime dateTableauBesoin) {
        this.dateTableauBesoin = dateTableauBesoin;
    }
}
