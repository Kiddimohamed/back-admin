package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur findByReferenceFournisseur(String referenceFournisseur);

    Fournisseur findByVilleFournisseur(String villeFournisseur);

    List<Fournisseur> findAll();

    int save(Fournisseur fournisseur);
    public int updateRib(Fournisseur fournisseur);



    }
