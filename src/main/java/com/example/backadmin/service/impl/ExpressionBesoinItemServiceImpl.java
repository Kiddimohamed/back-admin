package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Produit;
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
    public List<ExpressionBesoinItem> findAll() {
        return expressionBesoinItemDao.findAll();
    }

    @Override
    public ExpressionBesoinItem findByCode(String code) {
        return expressionBesoinItemDao.findByCode(code);
    }

    @Override
    public int save(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoin expressionBesoin = expressionBesoinService.findByReference(expressionBesoinItem.getExpressionBesoin().getReference());
        Produit produit = produitService.findByCode(expressionBesoinItem.getProduit().getCode());
        expressionBesoinItem.setProduit(produit);
        expressionBesoinItem.setExpressionBesoin(expressionBesoin);
        if (expressionBesoinItem.getQuantite() <= 0) {
            return -1;
        } else {
            expressionBesoinItem.setLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }

    @Override
    public Long getMaxId() {
        return expressionBesoinItemDao.getMaxId();
    }

    @Autowired
    private ExpressionBesoinItemDao expressionBesoinItemDao;
    @Autowired
    private ExpressionBesoinService expressionBesoinService;
    @Autowired
    private ProduitService produitService;

}
