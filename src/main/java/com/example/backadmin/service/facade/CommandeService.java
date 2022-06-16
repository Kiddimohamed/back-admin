package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Commande;

import java.util.List;

public interface CommandeService {
    Commande findByCode(String code);
    List<Commande> findByStatut(String statut);

    List<Commande> findAll();

    List<Commande> findByTableauBesoinItemReference(String reference);

//    List<Commande> findByServiceDemandeurReference(String reference);

    void update(Commande commande,String statut);

    int save(Commande commande);

    List<Commande> findByFournisseurReferenceFournisseur(String reference);

    List<Commande> findByRubriqueReference(String reference);
    //statistique
    int getnbrOfCommande();
    List<String> graph_commande_budjet(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12);




}
