package com.example.backadmin.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class NatureDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String ref;
    private String nom;
    @OneToMany
    private List<ExpressionBesoin> expressionBesoins;

    public List<ExpressionBesoin> getExpressionBesoins() {
        return expressionBesoins;
    }

    public void setExpressionBesoins(List<ExpressionBesoin> expressionBesoins) {
        this.expressionBesoins = expressionBesoins;
    }

    public NatureDemande(Long id, String ref, String nom) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
    }

    public NatureDemande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
