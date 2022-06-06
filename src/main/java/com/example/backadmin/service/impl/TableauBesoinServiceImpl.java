package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.dao.TableauBesoinDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableauBesoinServiceImpl implements TableauBesoinService {
    @Override
    public void save(TableauBesoin tableauBesoin) {
//        Fournisseur fournisseur=fournisseurService.findByReferenceFournisseur(tableauBesoin.getFournisseur().getReferenceFournisseur());
//        tableauBesoin.setFournisseur(fournisseur);
        tableauBesoin.getExpressionBesoinItems().forEach(e->{
        });
        tableauBesoin.setReference("t1"+tableauBesoin.getReference());
        tableauBesoinDao.save(tableauBesoin);
    }

    @Override
    public TableauBesoin findByReference(String reference) {
        return tableauBesoinDao.findByReference(reference);
    }

    @Autowired
    private TableauBesoinDao tableauBesoinDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
}
