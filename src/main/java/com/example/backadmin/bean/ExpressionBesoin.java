package com.example.backadmin.bean;

import com.example.backadmin.security.bean.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ExpressionBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String objet;
    private LocalDateTime dateExpressionBesoin;
    private String statut;
    private double totalTTC;
    private double totalHT;
    private double TVA;
//    private String Username;


    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ExpressionBesoinItem> expressionBesoinItemList;
    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commande> commandeList;


    @ManyToOne
    private User user;

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

    public LocalDateTime getDateExpressionBesoin() {
        return dateExpressionBesoin;
    }

    public void setDateExpressionBesoin(LocalDateTime dateExpressionBesoin) {
        this.dateExpressionBesoin = dateExpressionBesoin;
    }

    public List<ExpressionBesoinItem> getExpressionBesoinItemList() {
        return expressionBesoinItemList;
    }

    public void setExpressionBesoinItemList(List<ExpressionBesoinItem> expressionBesoinItemList) {
        this.expressionBesoinItemList = expressionBesoinItemList;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

//    public String getUsername() {
//        return Username;
//    }
//
//    public void setUsername(String Username) {
//        this.Username = Username;
//    }

    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

}
