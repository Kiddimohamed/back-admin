package com.example.backadmin.service.impl;

import com.example.backadmin.bean.*;

import com.example.backadmin.dao.ExpressionBesoinDao;

import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import com.example.backadmin.service.facade.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


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
        int res = validate(expressionBesoin);
        if (res > 0) {

            handelprocess(expressionBesoin);
            return 1;
        } else return res;


    }
    public void increment(ExpressionBesoin expressionBesoin) {
        int i;

    }


    private void prepare(ExpressionBesoin expressionBesoin) {/*
        User user = userService.findByReference(expressionBesoin.getUser().getReference());
//        userService.save(expressionBesoin.getUser());
        if (user==null){
        userService.save(expressionBesoin.getUser());
        User user1=userService.findByReference(expressionBesoin.getUser().getReference());
        expressionBesoin.setUser(user1);
        }else {
            expressionBesoin.setUser(user);
        }*/
        User user = userService.findByReference(expressionBesoin.getUser().getReference());
        expressionBesoin.setUser(user);

        NatureDemande natureDemande= natureDemandeService.findByNom(expressionBesoin.getNatureDemande().getNom());
        expressionBesoin.setNatureDemande(natureDemande);
//        expressionBesoin.getExpressionBesoinItems().forEach(e -> {
//
//            e.setExpressionBesoin(expressionBesoin);

//            ExpressionBesoin expressionBesoin1 = expressionBesoinService.findByRef(e.getExpressionBesoin().getRef());
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
            return -3;
        } else if(expressionBesoin.getUser()==null){
            return -4;
        } else {
            return 1;
        }
    }


    public void handelprocess(ExpressionBesoin expressionBesoin) {

        expressionBesoin.setStatut("En attente");
        expressionBesoin.setDateExb(LocalDateTime.now());
        expressionBesoin.setMonth(LocalDateTime.now().getMonth().toString());
        expressionBesoin.setReference("Exb-" + (getMaxId() + 1));
        expressionBesoinDao.save(expressionBesoin);
        expressionBesoin.getExpressionBesoinItems().forEach(expressionBesoinItem -> {
            produitService.save(expressionBesoinItem.getProduit());
            //Produit produit = produitService.findByLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItem.setExpressionBesoin(expressionBesoin);
            //expressionBesoinItem.setProduit(produit);
            expressionBesoinItem.setCode("ExpI-" + getMaxId() + "-" + (expressionBesoinItemService.getMaxId() + 1));
            expressionBesoinItemService.save(expressionBesoinItem);
        });
    }
    public void updateExpressionBesoin(ExpressionBesoin expressionBesoin) {

        ExpressionBesoin e = expressionBesoinDao.findByReference(expressionBesoin.getReference());
        e.setStatut("Acceptée");
        expressionBesoinDao.save(e);
    }

    @Override
    public void refuser(ExpressionBesoin expressionBesoin) {
        ExpressionBesoin e = expressionBesoinDao.findByReference(expressionBesoin.getReference());
        e.setStatut("Refusée");
        expressionBesoinDao.save(e);
    }
    public Long getMaxId() {
        return expressionBesoinDao.getMaxId();
    }


    //microservice************************************
    @Autowired
    private RestTemplate restTemplate;

    //statistique


    //statistique
    public int getNumberOfExpressionBesoinEnAttente(){
        return expressionBesoinDao.getNumberOfExpressionBesoinEnAttente();
    }

    @Autowired
    protected EntityManager entityManager;





    public List<BigDecimal> getNumbersOrderByMonth(String month){

        String query = "SELECT COUNT(e.id) FROM ExpressionBesoin e where E.month like :month group by e.month " ;

        return entityManager.createQuery(query).getResultList();     }


    public List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12) {
        List<String> expr_mois = new ArrayList<>();
        expr_mois.add(expressionBesoinDao.exp_par_mois(e1));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e2));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e3));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e4));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e5));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e6));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e7));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e8));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e9));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e10));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e11));
        expr_mois.add(expressionBesoinDao.exp_par_mois(e12));
        return expr_mois;

    }


    @Override
    public int expressionBesoinEncours() {
        return expressionBesoinDao.expressionBesoinEncours();
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
    @Autowired
   NatureDemandeService natureDemandeService;

}
