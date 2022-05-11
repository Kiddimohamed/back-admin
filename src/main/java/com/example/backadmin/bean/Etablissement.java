package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String libelle;
    private String adresse;
    private String telephone;
    private String fax;
    private String ville;
    private String email;
    private String siteWeb;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commande> commandeList;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Fax> faxeList;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private List<Employe> employeList;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ServiceDemandeur> serviceDemandeurList;

    // TODO ajouter image


    public List<ServiceDemandeur> getServiceDemandeurList() {
        return serviceDemandeurList;
    }

    public void setServiceDemandeurList(List<ServiceDemandeur> serviceDemandeurList) {
        this.serviceDemandeurList = serviceDemandeurList;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public List<Fax> getFaxeList() {
        return faxeList;
    }

    public void setFaxeList(List<Fax> faxeList) {
        this.faxeList = faxeList;
    }

    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

}
