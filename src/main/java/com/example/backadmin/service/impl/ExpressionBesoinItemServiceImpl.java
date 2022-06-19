package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.*;
import com.example.backadmin.dao.ExpressionBesoinItemDao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.ExpressionBesoinService;
import com.example.backadmin.service.facade.ProduitService;
import com.example.backadmin.service.facade.TableauBesoinService;
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

//    @Override
//    public List<ExpressionBesoinItem> findByTableauBesoinReference(String reference) {
//        return expressionBesoinItemDao.findByTableauBesoinReference(reference);
//    }

    @Override
    public List<ExpressionBesoinItem> findByRefExpr(String refExpr) {
        return expressionBesoinItemDao.findByRefExpr(refExpr);
    }


    @Override
    public int update(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem1 = expressionBesoinItemDao.findByCode(expressionBesoinItem.getCode());
        expressionBesoinItem1.setPu(expressionBesoinItem.getPu());
        expressionBesoinItem1.setPt(expressionBesoinItem.getPu()*expressionBesoinItem.getQuantite());
        expressionBesoinItem1.setStatut(expressionBesoinItem.getStatut());
//        TableauBesoin tableauBesoin = tableauBesoinService.findByReference(expressionBesoinItem.getTableauBesoin().getReference());
//        expressionBesoinItem1.setTableauBesoin(tableauBesoin);
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
        Produit produit = produitService.findByCode(expressionBesoinItem.getProduit().getCode());
//        ExpressionBesoin expressionBesoin=expressionBesoinService.findByReference(expressionBesoinItem.getExpressionBesoin().getReference());
//        expressionBesoinItem.setExpressionBesoin(expressionBesoin);
        if (produit==null){
            produitService.save(expressionBesoinItem.getProduit());
            Produit produit1 = produitService.findByCode(expressionBesoinItem.getProduit().getCode());
            expressionBesoinItem.setProduit(produit1);

        }else {
        expressionBesoinItem.setProduit(produit);}
//        expressionBesoinItem.setRefTabBesoin(expressionBesoinItem.getTableauBesoin().getReference());
        if (expressionBesoinItem.getQuantite() <= 0) {
            return -1;
        } else {
//            expressionBesoinItem.setLibelle(expressionBesoinItem.getProduit().getLibelle());
            expressionBesoinItem.setPt(expressionBesoinItem.getPu()*expressionBesoinItem.getQuantite());
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
    @Autowired
    private TableauBesoinService tableauBesoinService;

}
