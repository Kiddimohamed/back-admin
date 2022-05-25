package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chapitre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String libelleType;
    @ManyToOne
    private ChapitreType chapitreType;
    @OneToMany
    private List<Article> articleList;

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

    public ChapitreType getChapitreType() {
        return chapitreType;
    }

    public void setChapitreType(ChapitreType chapitreType) {
        this.chapitreType = chapitreType;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }
}
