package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.dao.ExpressionBesoinDao;
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
    public List<ExpressionBesoin> findByServiceDemandeurReference(String reference) {
        return expressionBesoinDao.findByServiceDemandeurReference(reference);
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

    public void increment(ExpressionBesoin expressionBesoin) {
        int i;

    }

    private void prepare(ExpressionBesoin expressionBesoin) {
//        Etablissement etablissement = etablissementService.findByReference(expressionBesoin.getServiceDemandeur().getEtablissement().getReference());

        ServiceDemandeur serviceDemandeur = serviceDemandeurService.findByReference(expressionBesoin.getServiceDemandeur().getReference());

//        serviceDemandeur.setEtablissement(etablissement);
        expressionBesoin.setServiceDemandeur(serviceDemandeur);


//        expressionBesoin.getExpressionBesoinItems().forEach(e -> {
//
//            e.setExpressionBesoin(expressionBesoin);

//            ExpressionBesoin expressionBesoin1 = expressionBesoinService.findByRef(e.getExpressionBesoin().getRef());
//        });
    }


    private int validate(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin expressionBesoin1 = findByReference(expressionBesoin.getReference());

        if (expressionBesoin1 != null) {
            return -1;
        } else if (expressionBesoin.getServiceDemandeur() == null) {
            return -2;
        } else {
            return 1;
        }
    }


    public int handelprocess(ExpressionBesoin expressionBesoin) {
        expressionBesoin.setStatut("En attente");
        expressionBesoin.setDateExpressionBesoin(LocalDateTime.now());
        expressionBesoin.setReference("Exb-" + (getMaxId() + 1));
        expressionBesoinDao.save(expressionBesoin);
        expressionBesoin.getExpressionBesoinItemList().forEach(expressionBesoinItem -> {
            produitService.save(expressionBesoinItem.getProduit());
            Produit produit=produitService.findByCode(expressionBesoinItem.getProduit().getCode());

            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
            expressionBesoinItem.setProduit(produit);
            //expressionBesoinItem.setProduit(produit);
            expressionBesoinItem.setCode("ExpI-" + getMaxId() + "-" + (expressionBesoinItemService.getMaxId() + 1));

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
    ServiceDemandeurService serviceDemandeurService;
    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
}
