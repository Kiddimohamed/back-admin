package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;

import com.example.backadmin.dao.ExpressionBesoinDao;

import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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


    //microservice************************************
    @Autowired
    private RestTemplate restTemplate;

    //statistique
    @Override
    public int expressionBesoinEncours(){
        return expressionBesoinDao.expressionBesoinEncours();
    }

    @Override
    public int getNumberOfExpressionBesoinEnAttente() {

        int x = restTemplate.getForObject("http://localhost:8095/centre-project/v1/expression-besoin/NumberOfExpressionBesoinEnAttente", Integer.class);
        return x;
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
