package com.example.backadmin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProduitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String refereneProduitType;
    private  String nomProduitType;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRefereneProduitType() {
        return refereneProduitType;
    }

    public void setRefereneProduitType(String refereneProduitType) {
        this.refereneProduitType = refereneProduitType;
    }

    public String getNomProduitType() {
        return nomProduitType;
    }

    public void setNomProduitType(String nomProduitType) {
        this.nomProduitType = nomProduitType;
    }
}
