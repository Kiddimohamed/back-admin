package com.example.backadmin.bean;

import com.example.backadmin.security.bean.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ExpressionBesoin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reference;
    private String objet;
    private LocalDateTime dateExb;
    private static int i;
    private String statut;
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @ManyToOne
    private User user;

    @OneToMany
    private List<ExpressionBesoinItem> expressionBesoinItems;

    @ManyToOne
    private NatureDemande natureDemande;


    public NatureDemande getNatureDemande() {
        return natureDemande;
    }

    public void setNatureDemande(NatureDemande natureDemande) {
        this.natureDemande = natureDemande;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjet() {
        return objet;
    }

    public List<ExpressionBesoinItem> getExpressionBesoinItems() {
        return expressionBesoinItems;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        ExpressionBesoin.i = i;
    }

    public void setExpressionBesoinItems(List<ExpressionBesoinItem> expressionBesoinItems) {
        this.expressionBesoinItems = expressionBesoinItems;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public LocalDateTime getDateExb() {
        return dateExb;
    }

    public void setDateExb(LocalDateTime dateExb) {
        this.dateExb = dateExb;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
