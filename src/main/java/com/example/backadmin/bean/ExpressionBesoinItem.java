package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class ExpressionBesoinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantite;
    private String code;

    @ManyToOne
    private ExpressionBesoin expressionBesoin;

    @OneToOne
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
}
