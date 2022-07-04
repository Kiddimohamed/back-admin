package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur findByReferenceFournisseur(String referenceFournisseur);

    List<Fournisseur> findByStatut(String statut);

    Fournisseur findByVilleFournisseur(String villeFournisseur);

    List<Fournisseur> findAll();

    int save(Fournisseur fournisseur);

    public int updateRib(Fournisseur fournisseur);


    int updateStatut(Fournisseur fournisseur);
}
