package com.example.backadmin.bean;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String raisonSociale;
    private String adresse;
    private double totalTtc;
    private double totalHt;
    private double TVA;
    private Date dateCommande;
    private String etablissement;
    private String serviceDemandeur;
    private String exercice;
    private String nature;
    private String statut;



    private String month;
    @ManyToOne
    private Employe ordonnateur;
    @ManyToOne
    private TableauBesoinItem tableauBesoinItem;
    @ManyToOne
    private Fournisseur fournisseur;
    @ManyToOne
    private Rubrique rubrique;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<CommandeItem> commandeItemList;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<CommandeItem> getCommandeItemList() {
        return commandeItemList;
    }

    public void setCommandeItemList(List<CommandeItem> commandeItemList) {
        this.commandeItemList = commandeItemList;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getServiceDemandeur() {
        return serviceDemandeur;
    }

    public void setServiceDemandeur(String serviceDemandeur) {
        this.serviceDemandeur = serviceDemandeur;
    }

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public TableauBesoinItem getTableauBesoinItem() {
        return tableauBesoinItem;
    }

    public void setTableauBesoinItem(TableauBesoinItem tableauBesoinItem) {
        this.tableauBesoinItem = tableauBesoinItem;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
