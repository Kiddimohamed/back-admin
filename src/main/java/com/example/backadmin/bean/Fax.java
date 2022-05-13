package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Fax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceFax;
    private String objetFax;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FaxType faxType;

    @ManyToOne
    private Employe emetteur;

    @OneToOne
    private ExpressionBesoin expressionBesoin;

    @ManyToOne
    private Fournisseur fournisseur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceFax() {
        return referenceFax;
    }

    public void setReferenceFax(String referenceFax) {
        this.referenceFax = referenceFax;
    }

    public String getObjetFax() {
        return objetFax;
    }

    public void setObjetFax(String objetFax) {
        this.objetFax = objetFax;
    }

    public FaxType getFaxType() {
        return faxType;
    }

    public void setFaxType(FaxType faxType) {
        this.faxType = faxType;
    }

    public Employe getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Employe emetteur) {
        this.emetteur = emetteur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public ExpressionBesoin getExpressionBesoin() {
        return expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
    }
}

