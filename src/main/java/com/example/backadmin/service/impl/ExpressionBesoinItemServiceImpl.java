package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.User;
import com.example.backadmin.dao.ExpressionBesoinItemDao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import com.example.backadmin.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionBesoinItemServiceImpl implements ExpressionBesoinItemService {

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference) {
        return expressionBesoinItemDao.findByExpressionBesoinReference(reference);
    }

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut) {
        return expressionBesoinItemDao.findByExpressionBesoinStatut(statut);
    }

    @Override
    public List<ExpressionBesoinItem> findAll() {
        return expressionBesoinItemDao.findAll();
    }


    @Override
    public int update(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem1 = expressionBesoinItemDao.findByCode(expressionBesoinItem.getCode());
        expressionBesoinItem1.setPu(expressionBesoinItem.getPu());
        expressionBesoinItemDao.save(expressionBesoinItem1);
        System.out.println(expressionBesoinItem1.getQuantite());
        return 1;
    }

    @Override
    public ExpressionBesoinItem findByCode(String code) {
        return expressionBesoinItemDao.findByCode(code);
    }

    @Override
    public Long getMaxId() {
        return expressionBesoinItemDao.getMaxId();
    }

    @Override
    public int save(ExpressionBesoinItem expressionBesoinItem) {
        produitService.save(expressionBesoinItem.getProduit());
        Produit produit = produitService.findByCode(expressionBesoinItem.getProduit().getCode());
        expressionBesoinItem.setProduit(produit);
        if (expressionBesoinItem.getQuantite() <= 0) {
            return -1;
        } else {
//            expressionBesoinItem.setLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItem.setCode("e" + expressionBesoinItem.getId());
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }


    @Override
    public List<ExpressionBesoinItem> findByStatut(String statut) {
        return expressionBesoinItemDao.findByStatut(statut);
    }


    @Autowired
    private ExpressionBesoinItemDao expressionBesoinItemDao;
    @Autowired
    private ExpressionBesoinService expressionBesoinService;
    @Autowired
    private ProduitService produitService;

}
