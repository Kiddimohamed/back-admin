package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoinItem1;
import com.example.backadmin.dao.TableauBesoinItem1Dao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TableauBesoinItem1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauBesoinItem1ServiceImpl implements TableauBesoinItem1Service {
private static int i=0;

    @Override
    public TableauBesoinItem1 findByReference(String reference) {
        return tableauBesoinItemDao.findByReference(reference);
    }

    @Override
    public List<TableauBesoinItem1> findAll() {
        return tableauBesoinItemDao.findAll();
    }

    @Override
    public List<TableauBesoinItem1> findByExpressionBesoinItemCode(String code) {
        return tableauBesoinItemDao.findByExpressionBesoinItemCode(code);
    }

    @Override
    public TableauBesoinItem1 findByFournisseurReferenceFournisseur(String reference) {
        return tableauBesoinItemDao.findByFournisseurReferenceFournisseur(reference);
    }

    @Override
    public List<TableauBesoinItem1> findByStatut(String statut) {
        return tableauBesoinItemDao.findByStatut(statut);
    }


    @Override
    public void update(TableauBesoinItem1 tableauBesoinItem) {
        TableauBesoinItem1 tableauBesoinItem1=tableauBesoinItemDao.findByReference(tableauBesoinItem.getReference());
       tableauBesoinItemDao.save(tableauBesoinItem1);
    }
    @Override
    public int save(TableauBesoinItem1 tableauBesoinItem1) {
        prepare(tableauBesoinItem1);
//        tableauBesoinItem1.setPu(tableauBesoinItem1.getExpressionBesoinItem().getPu());
//        tableauBesoinItem1.setDesignation(tableauBesoinItem1.getExpressionBesoinItem().getLibelle());
//        tableauBesoinItem1.setQuantite(tableauBesoinItem1.getExpressionBesoinItem().getQuantite());
//        TableauBesoinItem tableauBesoinItem1 = findByReference(tableauBesoinItem.getReference());
//        if (tableauBesoinItem1 != null) return -1;
//        else {
        tableauBesoinItem1.setReference("t"+System.currentTimeMillis());
            tableauBesoinItemDao.save(tableauBesoinItem1);
            return 1;

//        }
    }

    private void prepare(TableauBesoinItem1 tableauBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem = expressionBesoinItemService.findByCode(tableauBesoinItem.getExpressionBesoinItem().getCode());
        tableauBesoinItem.setExpressionBesoinItem(expressionBesoinItem);
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(tableauBesoinItem.getFournisseur().getReferenceFournisseur());
        tableauBesoinItem.setFournisseur(fournisseur);
    }

    @Autowired
    private TableauBesoinItem1Dao tableauBesoinItemDao;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
    @Autowired
    private FournisseurService fournisseurService;
}
