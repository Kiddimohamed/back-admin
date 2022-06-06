package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;

import com.example.backadmin.dao.ExpressionBesoinDao;

import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {

    @Override
    public ExpressionBesoin findByObjet(String objet) {
        return expressionBesoinDao.findByObjet(objet);
    }

    @Override
    public ExpressionBesoin findByReference(String reference) {
        return expressionBesoinDao.findByReference(reference);
    }

    @Override
    public List<ExpressionBesoin> findByStatut(String statut) {
        return expressionBesoinDao.findByStatut(statut);
    }


    @Override
    public List<ExpressionBesoin> findAll() {
        return expressionBesoinDao.findAll();
    }

    // TODO all Delete
    // TODO Validate a Simo

    @Override
    public int save(ExpressionBesoin expressionBesoin) {
saveNull(expressionBesoin);
//        int res = validate(expressionBesoin);
//        if (res > 0) {
//        }

        return handelprocess(expressionBesoin);


    }


    private void prepare(ExpressionBesoin expressionBesoin) {
//        Etablissement etablissement = etablissementService.findByReference(expressionBesoin.getServiceDemandeur().getEtablissement().getReference());
        userService.save(expressionBesoin.getUser());
        User user = userService.findByReference(expressionBesoin.getUser().getReference());
//        if (user == null) {
//            userService.save(expressionBesoin.getUser());
//        }
        expressionBesoin.setUser(user);


//        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(expressionBesoin.getServiceDemandeur().getReference());
//
////        serviceDemandeur.setEtablissement(etablissement);
//      expressionBesoin.setServiceDemandeur(serviceDemandeur);

//        expressionBesoin.getExpressionBesoinItems().forEach(e -> {
//
//            e.setExpressionBesoin(expressionBesoin);

//            ExpressionBesoin expressionBesoin1 = findByReference(e.getExpressionBesoin().getReference());
//        });
    }

    @Override
    public void saveNull(ExpressionBesoin expressionBesoin) {
        prepare(expressionBesoin);
        expressionBesoinDao.save(expressionBesoin);

    }

    private int validate(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin expressionBesoin1 = findByReference(expressionBesoin.getReference());

        if (expressionBesoin1 != null) {
            return -1;
//        } else if (expressionBesoin.getUser().getServiceDemandeur() == null) {
//            return -2;
        } else {
            return 1;
        }
    }


    public int handelprocess(ExpressionBesoin expressionBesoin) {

        expressionBesoin.getExpressionBesoinItems().forEach(expressionBesoinItem -> {
//            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
//            produitService.save(expressionBesoinItem.getProduit());
//            //Produit produit = produitService.findByLibelle(expressionBesoinItem.getProduit().getLibelle());
//            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
            //expressionBesoinItem.setProduit(produit);
            expressionBesoinItemService.save(expressionBesoinItem);
        });

        return 1;
    }

    public Long getMaxId() {
        return expressionBesoinDao.getMaxId();
    }

    @Autowired
    ExpressionBesoinDao expressionBesoinDao;
    @Autowired
    EmployeService employeService;
    @Autowired
    ProduitService produitService;
    @Autowired
    EtablissementService etablissementService;
    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
    @Autowired
    UserService userService;
    @Autowired
    ServiceDemandeurService serviceDemandeurService;

}
