package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paragraphe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long  id;
    private String reference;

    private String libelleArticle;
    private String libelleChapitre;
    private String libellePara;


    @ManyToOne
    private Article article;
    @OneToMany
    private List<Ligne> ligneList;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Ligne> getLigneList() {
        return ligneList;
    }

    public void setLigneList(List<Ligne> ligneList) {
        this.ligneList = ligneList;
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

    public String getLibellePara() {
        return libellePara;
    }

    public void setLibellePara(String libellePara) {
        this.libellePara = libellePara;
    }
}

