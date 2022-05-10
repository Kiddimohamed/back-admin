package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.dao.ExpressionBesoinItemDao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
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
        ExpressionBesoinItem expressionBesoinItem1 = findByCode(expressionBesoinItem.getCode());
        Produit produit = produitService.findByCode(expressionBesoinItem.getCode());
        expressionBesoinItem.setProduit(produit);
        if (expressionBesoinItem1 != null) {
            return -1;
        } else if (produit == null) {
            return -2;
        } else {
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }

    }

    @Autowired
    private ExpressionBesoinItemDao expressionBesoinItemDao;

    @Autowired
    private ProduitService produitService;

}
