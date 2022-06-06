package com.example.backadmin.service.impl;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.dao.TableauBesoinItemDao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauBesoinItemServiceImpl implements TableauBesoinItemService {


    @Override
    public TableauBesoinItem findByReference(String reference) {
        return tableauBesoinItemDao.findByReference(reference);
    }

    @Override
    public List<TableauBesoinItem> findAll() {
        return tableauBesoinItemDao.findAll();
    }

    @Override
    public List<TableauBesoinItem> findByExpressionBesoinItemCode(String code) {
        return tableauBesoinItemDao.findByExpressionBesoinItemCode(code);
    }
    @Override
    public void update(TableauBesoinItem tableauBesoinItem) {
        TableauBesoinItem tableauBesoinItem1=tableauBesoinItemDao.findByReference(tableauBesoinItem.getReference());
       tableauBesoinItemDao.save(tableauBesoinItem1);
    }
    @Override
    public int save(TableauBesoinItem tableauBesoinItem) {
        prepare(tableauBesoinItem);
//        TableauBesoinItem tableauBesoinItem1 = findByReference(tableauBesoinItem.getReference());
//        if (tableauBesoinItem1 != null) return -1;
//        else {
            tableauBesoinItem.setReference("t"+tableauBesoinItem.getId());
            tableauBesoinItemDao.save(tableauBesoinItem);
            return 1;
//        }
    }

    private void prepare(TableauBesoinItem tableauBesoinItem) {
        ExpressionBesoinItem expressionBesoinItem = expressionBesoinItemService.findByCode(tableauBesoinItem.getExpressionBesoinItem().getCode());
        tableauBesoinItem.setExpressionBesoinItem(expressionBesoinItem);
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(tableauBesoinItem.getFournisseur().getReferenceFournisseur());
        tableauBesoinItem.setFournisseur(fournisseur);
    }

    @Autowired
    private TableauBesoinItemDao tableauBesoinItemDao;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
    @Autowired
    private FournisseurService fournisseurService;
}
