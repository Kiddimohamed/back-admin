package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class ChapitreType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String type;
    @OneToMany
    private List<Chapitre> chapitres;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(List<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }
}
