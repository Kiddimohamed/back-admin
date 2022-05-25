package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String code;
    private String rebrique;
    private String creditPaiement;
    private String Rap;
    private String Arrieres;
    private String codeFonc;
    private String codeCGNC;

    private String libelleArticle;
    private String libelleChapitre;
    private String libelleParagraphe;
    private String libelleNaturePrestation;

    @ManyToOne
    private NaturePrestation naturePrestation;

    @ManyToOne
    private Paragraphe paragraphe;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRebrique() {
        return rebrique;
    }

    public void setRebrique(String rebrique) {
        this.rebrique = rebrique;
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

    public String getCodeFonc() {
        return codeFonc;
    }

    public void setCodeFonc(String codeFonc) {
        this.codeFonc = codeFonc;
    }

    public String getCodeCGNC() {
        return codeCGNC;
    }

    public void setCodeCGNC(String codeCGNC) {
        this.codeCGNC = codeCGNC;
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

    public String getLibelleNaturePrestation() {
        return libelleNaturePrestation;
    }

    public void setLibelleNaturePrestation(String libelleNaturePrestation) {
        this.libelleNaturePrestation = libelleNaturePrestation;
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
}
