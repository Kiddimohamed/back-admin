package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String code;
    private String libelleChapitre;

    @OneToMany
    private List<Paragraphe> paragrapheList;

    @ManyToOne
    private Chapitre chapitre;


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

    public String getLibelleChapitre() {
        return libelleChapitre;
    }

    public void setLibelleChapitre(String libelleChapitre) {
        this.libelleChapitre = libelleChapitre;
    }

    public List<Paragraphe> getParagrapheList() {
        return paragrapheList;
    }

    public void setParagrapheList(List<Paragraphe> paragrapheList) {
        this.paragrapheList = paragrapheList;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }
}
