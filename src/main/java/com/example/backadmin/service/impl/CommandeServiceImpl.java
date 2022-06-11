package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;
import com.example.backadmin.dao.CommandeDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Commande> findByExpressionBesoinReference(String reference) {
        return commandeDao.findByExpressionBesoinReference(reference);
    }
//
//    @Override
//    public List<Commande> findByServiceDemandeurReference(String reference) {
//        return commandeDao.findByServiceDemandeurReference(reference);
//    }

    @Override
    public int save(Commande commande) {
        Commande commande1 = findByCode(commande.getCode());
        prepare(commande);
        if (commande1 != null) {
            return -1;
        } else if (commande.getEtablissement() == null || commande.getExpressionBesoin() == null || commande.getFournisseur() == null || commande.getOrdonnateur() == null || commande.getServiceDemandeur() == null) {
            return -4;
        } else {
            commande.getExpressionBesoin().setStatut("En attent de livraison");
            commande.setEtablissement(commande.getOrdonnateur().getEtablissement().getReference());
//            commande.setServiceDemandeur(commande.getExpressionBesoin().getUser().getServiceDemandeur());

            commandeDao.save(commande);
            commande.getCommandeItemList().forEach(commandeItem -> {
                commandeItem.setCommande(commande);
                commandeItemService.save(commandeItem);
            });
            return 1;
        }
    }

    private void prepare(Commande commande) {
        Employe employe = employeService.findByReferenceEmploye(commande.getOrdonnateur().getReferenceEmploye());
        commande.setOrdonnateur(employe);
        ExpressionBesoin expressionBesoin = expressionBesoinService.findByReference(commande.getExpressionBesoin().getReference());
        commande.setExpressionBesoin(expressionBesoin);
//        Etablissement etablissement = etablissementService.findByReference(commande.getOrdonnateur().getEtablissement().getReference());
//        commande.setEtablissement(etablissement);
//        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(commande.getServiceDemandeur().getReference());
//        commande.setServiceDemandeur(serviceDemandeur);
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(commande.getFournisseur().getReferenceFournisseur());
        commande.setFournisseur(fournisseur);
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
}
