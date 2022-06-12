package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;
import com.example.backadmin.dao.CommandeDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {


    @Override
    public Commande findByCode(String code) {
        return commandeDao.findByCode(code);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public List<Commande> findByTableauBesoinItemReference(String reference) {
        return commandeDao.findByTableauBesoinItemReference(reference);
    }


    @Override
    public int save(Commande commande) {
        Commande commande1 = findByCode(commande.getCode());
        prepare(commande);
        if (commande1 != null) {
            return -1;
//        } else if (commande.getEtablissement() == null || commande.getTableauBesoinItem() == null || commande.getFournisseur() == null || commande.getOrdonnateur() == null || commande.getServiceDemandeur() == null) {
//            return -4;
        } else {
            commande.getTableauBesoinItem().setStatut("En attent de livraison");
            commande.setMonth(LocalDateTime.now().getMonth().toString());
//            commande.setEtablissement(commande.getOrdonnateur().getEtablissement().getReference());
//            commande.setServiceDemandeur(commande.getExpressionBesoin().getUser().getServiceDemandeur());

            commandeDao.save(commande);
//            commande.getCommandeItemList().forEach(commandeItem -> {
//                commandeItem.setCommande(commande);
//                commandeItemService.save(commandeItem);
//            });
            return 1;
        }
    }

    private void prepare(Commande commande) {
        Employe employe = employeService.findByReferenceEmploye(commande.getOrdonnateur().getReferenceEmploye());
        commande.setOrdonnateur(employe);
//        ExpressionBesoin expressionBesoin = expressionBesoinService.findByReference(commande.getTableauBesoinItem().getReference());
      TableauBesoinItem tableauBesoinItem=tableauBesoinItemService.findByReference(commande.getTableauBesoinItem().getReference());
        commande.setTableauBesoinItem(tableauBesoinItem);
//        Etablissement etablissement = etablissementService.findByReference(commande.getOrdonnateur().getEtablissement().getReference());
//        commande.setEtablissement(etablissement);
//        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(commande.getServiceDemandeur().getReference());
//        commande.setServiceDemandeur(serviceDemandeur);
//        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(commande.getFournisseur().getReferenceFournisseur());
//        commande.setFournisseur(fournisseur);
        Rubrique rubrique=rubriqueService.findByReference(commande.getRubrique().getReference());
        commande.setRubrique(rubrique);
    }


    //jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj


    @Override
    public List<Commande> findByFournisseurReferenceFournisseur(String reference) {
        return commandeDao.findByFournisseurReferenceFournisseur(reference);
    }

    @Override
    public List<Commande> findByRubriqueReference(String reference) {
        return commandeDao.findByRubriqueReference(reference);
    }
    //statistique

    public int getnbrOfCommande(){
        return commandeDao.getnbrOfCommande();
    }











    public List<String> graph_commande_budjet(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
        List<String> commandes_mois = new ArrayList<>();
        commandes_mois.add(commandeDao.ttc_par_mois(e1));
        commandes_mois.add(commandeDao.ttc_par_mois(e2));
        commandes_mois.add(commandeDao.ttc_par_mois(e3));
        commandes_mois.add(commandeDao.ttc_par_mois(e4));
        commandes_mois.add(commandeDao.ttc_par_mois(e5));
        commandes_mois.add(commandeDao.ttc_par_mois(e6));
        commandes_mois.add(commandeDao.ttc_par_mois(e7));
        commandes_mois.add(commandeDao.ttc_par_mois(e8));
        commandes_mois.add(commandeDao.ttc_par_mois(e9));
        commandes_mois.add(commandeDao.ttc_par_mois(e10));
        commandes_mois.add(commandeDao.ttc_par_mois(e11));
        commandes_mois.add(commandeDao.ttc_par_mois(e12));
        return commandes_mois;

    }




    @Autowired
    CommandeDao commandeDao;
    @Autowired
    EmployeService employeService;
    @Autowired
    ServiceDemandeurService serviceDemandeurService;
    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;

    @Autowired
    RubriqueService rubriqueService;
    @Autowired
    LigneService ligneService;
    @Autowired
    CommandeItemService commandeItemService;


    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    EtablissementService etablissementService;

    @Autowired
    ExpressionBesoinService expressionBesoinService;
    @Autowired
    TableauBesoinItemService tableauBesoinItemService;
}
