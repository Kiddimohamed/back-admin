package com.example.backadmin.service.impl;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.dao.TableauBesoinDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauBesoinServiceImpl implements TableauBesoinService {
    @Override
    public void save(TableauBesoin tableauBesoin) {
//        Fournisseur fournisseur=fournisseurService.findByReferenceFournisseur(tableauBesoin.getFournisseur().getReferenceFournisseur());
//        tableauBesoin.setFournisseur(fournisseur);

        tableauBesoin.setReference("tab_" + System.currentTimeMillis());
        tableauBesoinDao.save(tableauBesoin);
        tableauBesoin.getExpressionBesoinItems().forEach(e -> {
            e.setStatut("envoyee");
            expressionBesoinItemService.save(e);
        });
//        tableauBesoin.setReference("t1"+tableauBesoin.getReference());
        tableauBesoinDao.save(tableauBesoin);
    }

    @Override
    public void update(TableauBesoin tableauBesoin) {
        TableauBesoin tableauBesoin1 = tableauBesoinDao.findByReference(tableauBesoin.getReference());
        tableauBesoin1.setStatut("envoye");
        tableauBesoinDao.save(tableauBesoin1);
    }

    @Override
    public TableauBesoin findByReference(String reference) {
        return tableauBesoinDao.findByReference(reference);
    }

    @Override
    public List<TableauBesoin> findAll() {
        return tableauBesoinDao.findAll();
    }

    @Override
    public List<TableauBesoin> findByStatut(String statut) {
        return tableauBesoinDao.findByStatut(statut);
    }

    @Autowired
    private TableauBesoinDao tableauBesoinDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
}
