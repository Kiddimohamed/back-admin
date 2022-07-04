package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceFournisseur;
    private String nomFournisseur;
    private String raisonSocial;
    private String adresseFournisseur;
    private String telephoneFournisseur;
    private String faxFournisseur;
    private String villeFournisseur;
    private String emailFournisseur;
    private String rib;
    private String statut;


    @OneToMany
    private List<Commande> commandeList;

    @OneToMany
    private List<FournisseurItem> fournisseurItems;
    @OneToMany
    private List<TableauBesoinItem> tableauBesoinItems;
    // TODO CategoryProduit

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }


    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    public String getVilleFournisseur() {
        return villeFournisseur;
    }

    public void setVilleFournisseur(String villeFournisseur) {
        this.villeFournisseur = villeFournisseur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceFournisseur() {
        return referenceFournisseur;
    }

    public void setReferenceFournisseur(String referenceFournisseur) {
        this.referenceFournisseur = referenceFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getTelephoneFournisseur() {
        return telephoneFournisseur;
    }

    public void setTelephoneFournisseur(String telephoneFournisseur) {
        this.telephoneFournisseur = telephoneFournisseur;
    }

    public String getFaxFournisseur() {
        return faxFournisseur;
    }

    public void setFaxFournisseur(String faxFournisseur) {
        this.faxFournisseur = faxFournisseur;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public List<FournisseurItem> getFournisseurItems() {
        return fournisseurItems;
    }

    public void setFournisseurItems(List<FournisseurItem> fournisseurItems) {
        this.fournisseurItems = fournisseurItems;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
