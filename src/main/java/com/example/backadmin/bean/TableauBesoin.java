package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TableauBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String statut;
    private double tva;
    private double ttc;
    @OneToMany
    private List<ExpressionBesoinItem> expressionBesoinItems;
//    @OneToMany
//    private List<TableauBesoinItem> tableauBesoinItems;

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

    public List<ExpressionBesoinItem> getExpressionBesoinItems() {
        return expressionBesoinItems;
    }

    public void setExpressionBesoinItems(List<ExpressionBesoinItem> expressionBesoinItems) {
        this.expressionBesoinItems = expressionBesoinItems;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

//    public List<TableauBesoinItem> getTableauBesoinItems() {
//        return tableauBesoinItems;
//    }
//
//    public void setTableauBesoinItems(List<TableauBesoinItem> tableauBesoinItems) {
//        this.tableauBesoinItems = tableauBesoinItems;
//    }
}
