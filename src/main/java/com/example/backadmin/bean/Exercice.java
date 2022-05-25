package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String reference;
    private String libelle;
    @OneToMany
    private List<Chapitre> chapitreList;

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

    public List<Chapitre> getChapitreList() {
        return chapitreList;
    }

    public void setChapitreList(List<Chapitre> chapitreList) {
        this.chapitreList = chapitreList;
    }
}
