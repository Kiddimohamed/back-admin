package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Commande;

import java.util.List;

public interface CommandeService {
    Commande findByCode(String code);

    List<Commande> findAll();

    List<Commande> findByTableauBesoinItemReference(String reference);

//    List<Commande> findByServiceDemandeurReference(String reference);

    int save(Commande commande);

    List<Commande> findByFournisseurReferenceFournisseur(String reference);

    List<Commande> findByRubriqueReference(String reference);
    //statistique
    int getnbrOfCommande();



}
