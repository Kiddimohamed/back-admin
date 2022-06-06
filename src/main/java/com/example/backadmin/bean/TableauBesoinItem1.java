package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class TableauBesoinItem1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    @ManyToOne
    private Fournisseur fournisseur;
    @ManyToOne
    private ExpressionBesoinItem expressionBesoinItem;
    @ManyToOne
    private TableauBesoin tableauBesoin;

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

    public TableauBesoin getTableauBesoin() {
        return tableauBesoin;
    }

    public void setTableauBesoin(TableauBesoin tableauBesoin) {
        this.tableauBesoin = tableauBesoin;
    }
}
