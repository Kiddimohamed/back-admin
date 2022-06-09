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

        return 1;


    }


    private void prepare(ExpressionBesoin expressionBesoin) {
        userService.save(expressionBesoin.getUser());
        User user = userService.findByReference(expressionBesoin.getUser().getReference());
        expressionBesoin.setUser(user);
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
