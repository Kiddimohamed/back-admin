package com.example.backadmin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String code;
    private String libelle;
    private String creditPaiement;
    private String Rap;
    private String Arrieres;
    private String libelleFonc;
    private String libelleCGNC;

    private String libelleArticle;
    private String libelleChapitre;
    private String libelleParagraphe;
    private String codeNaturePrestation;

    @ManyToOne
    private NaturePrestation naturePrestation;

    @ManyToOne
    private Paragraphe paragraphe;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<Rubrique> rubriqueList;

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



    public String getCreditPaiement() {
        return creditPaiement;
    }

    public void setCreditPaiement(String creditPaiement) {
        this.creditPaiement = creditPaiement;
    }

    public String getRap() {
        return Rap;
    }

    public void setRap(String rap) {
        Rap = rap;
    }

    public String getArrieres() {
        return Arrieres;
    }

    public void setArrieres(String arrieres) {
        Arrieres = arrieres;
    }

    public String getLibelleFonc() {
        return libelleFonc;
    }

    public void setLibelleFonc(String libelleFonc) {
        this.libelleFonc = libelleFonc;
    }

    public String getLibelleCGNC() {
        return libelleCGNC;
    }

    public void setLibelleCGNC(String libelleCGNC) {
        this.libelleCGNC = libelleCGNC;
    }

    public String getLibelleArticle() {
        return libelleArticle;
    }

    public void setLibelleArticle(String libelleArticle) {
        this.libelleArticle = libelleArticle;
    }

    public String getLibelleChapitre() {
        return libelleChapitre;
    }

    public void setLibelleChapitre(String libelleChapitre) {
        this.libelleChapitre = libelleChapitre;
    }

    public String getLibelleParagraphe() {
        return libelleParagraphe;
    }

    public void setLibelleParagraphe(String libelleParagraphe) {
        this.libelleParagraphe = libelleParagraphe;
    }

    public String getCodeNaturePrestation() {
        return codeNaturePrestation;
    }

    public void setCodeNaturePrestation(String codeNaturePrestation) {
        this.codeNaturePrestation = codeNaturePrestation;
    }

    public NaturePrestation getNaturePrestation() {
        return naturePrestation;
    }

    public void setNaturePrestation(NaturePrestation naturePrestation) {
        this.naturePrestation = naturePrestation;
    }

    public Paragraphe getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(Paragraphe paragraphe) {
        this.paragraphe = paragraphe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rubrique> getRubriqueList() {
        return rubriqueList;
    }

    public void setRubriqueList(List<Rubrique> rubriqueList) {
        this.rubriqueList = rubriqueList;
    }
}
