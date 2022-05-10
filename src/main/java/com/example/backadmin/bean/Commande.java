package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String exercice;
    private String chapitre;
    private String article;
    private String paragraphe;



    private String ligne;
    private String naturePrestation;
    private String raisonSociale;
    private String adresse;
    private double totalTtc;
    private double totalHt;
    private double TVA;
    private Date dateCommande;

    @ManyToOne
    private Employe ordonnateur;

    @ManyToOne
    private ExpressionBesoin expressionBesoin;

    @ManyToOne
    private Etablissement etablissement;

    @ManyToOne
    private Fournisseur fournisseur;

     @ManyToOne
    private ServiceDemandeur serviceDemandeur;

    @OneToMany
    private List<CommandeItem> commandeItemList;


    public List<CommandeItem> getCommandeItemList() {
        return commandeItemList;
    }

    public void setCommandeItemList(List<CommandeItem> commandeItemList) {
        this.commandeItemList = commandeItemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceDemandeur getServiceDemandeur() {
        return serviceDemandeur;
    }

    public void setServiceDemandeur(ServiceDemandeur serviceDemandeur) {
        this.serviceDemandeur = serviceDemandeur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public String getChapitre() {
        return chapitre;
    }

    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(String paragraphe) {
        this.paragraphe = paragraphe;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public String getNaturePrestation() {
        return naturePrestation;
    }

    public void setNaturePrestation(String naturePrestation) {
        this.naturePrestation = naturePrestation;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(double totalTtc) {
        this.totalTtc = totalTtc;
    }

    public double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(double totalHt) {
        this.totalHt = totalHt;
    }
    public double getTVA() {
        return TVA;
    }

    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }


    public Employe getOrdonnateur() {
        return ordonnateur;
    }

    public void setOrdonnateur(Employe ordonnateur) {
        this.ordonnateur = ordonnateur;
    }

    public ExpressionBesoin getExpressionBesoin() {
        return expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
