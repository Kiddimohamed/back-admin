package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.ServiceDemandeur;

import com.example.backadmin.dao.ExpressionBesoinDao;
import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        prepare(expressionBesoin);

//        int res = validate(expressionBesoin);
//        if (res > 0) {
//        }

        return handelprocess(expressionBesoin);


    }


    private void prepare(ExpressionBesoin expressionBesoin) {
//        Etablissement etablissement = etablissementService.findByReference(expressionBesoin.getServiceDemandeur().getEtablissement().getReference());
//
        userService.save(expressionBesoin.getUser());
        User user = userService.findByRef(expressionBesoin.getUser().getRef());
          expressionBesoin.setUser(user);
//        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(expressionBesoin.getServiceDemandeur().getReference());
//
////        serviceDemandeur.setEtablissement(etablissement);
//      expressionBesoin.setServiceDemandeur(serviceDemandeur);

//        expressionBesoin.getExpressionBesoinItemList().forEach(e -> {
//
//            e.setExpressionBesoin(expressionBesoin);

//            ExpressionBesoin expressionBesoin1 = findByReference(e.getExpressionBesoin().getReference());
//        });
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

        expressionBesoin.setDateExpressionBesoin(LocalDateTime.now());
//        expressionBesoin.setStatut("en Cours");
//        expressionBesoin.setUsername(expressionBesoin.getUser().getUsername());
        expressionBesoinDao.save(expressionBesoin);
        System.out.println(expressionBesoin.getStatut());
//        expressionBesoin.getExpressionBesoinItemList().forEach(expressionBesoinItem -> {
//            produitService.save(expressionBesoinItem.getProduit());
//            Produit produit = produitService.findByCode(expressionBesoinItem.getProduit().getCode());
//
//            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
//            expressionBesoinItem.setProduit(produit);
//           //expressionBesoinItem.setProduit(produit);
//
//            expressionBesoinItemService.save(expressionBesoinItem);
//
//        });

//        userService.save(expressionBesoin.getUser());

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
