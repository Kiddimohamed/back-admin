package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ExpressionBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String objet;
    private Date dateExpressionBesoin;
    private double totalTTC;
    private double totalHT;
    private double TVA;

    @OneToMany
    private List<ExpressionBesoinItem> expressionBesoinItemList;
    @OneToMany
    private List<Commande> commandeList;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private ServiceDemandeur serviceDemandeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDateExpressionBesoin() {
        return dateExpressionBesoin;
    }

    public void setDateExpressionBesoin(Date dateExpressionBesoin) {
        this.dateExpressionBesoin = dateExpressionBesoin;
    }

    public List<ExpressionBesoinItem> getExpressionBesoinItemList() {
        return expressionBesoinItemList;
    }

    public void setExpressionBesoinItemList(List<ExpressionBesoinItem> expressionBesoinItemList) {
        this.expressionBesoinItemList = expressionBesoinItemList;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public ServiceDemandeur getServiceDemandeur() {
        return serviceDemandeur;
    }

    public void setServiceDemandeur(ServiceDemandeur serviceDemandeur) {
        this.serviceDemandeur = serviceDemandeur;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(double totalHT) {
        this.totalHT = totalHT;
    }

    public double getTVA() {
        return TVA;
    }


    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

}
