package com.example.backadmin.bean;

import javax.persistence.*;

@Entity
public class Rubrique {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String libelle;
    private String code;

    private String codeLigne;
    private String codeParagraphe;
    private String codeArticle;
    private String libelleLigne;

    @ManyToOne
    private Ligne ligne;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeLigne() {
        return codeLigne;
    }

    public void setCodeLigne(String codeLigne) {
        this.codeLigne = codeLigne;
    }

    public String getCodeParagraphe() {
        return codeParagraphe;
    }

    public void setCodeParagraphe(String codeParagraphe) {
        this.codeParagraphe = codeParagraphe;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getLibelleLigne() {
        return libelleLigne;
    }

    public void setLibelleLigne(String libelleLigne) {
        this.libelleLigne = libelleLigne;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }
}
