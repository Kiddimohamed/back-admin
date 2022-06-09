package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.dao.TableauBesoinItemDao;
import com.example.backadmin.service.facade.ExpressionBesoinItemService;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauBesoinItemServiceImpl implements TableauBesoinItemService {
    @Override
    public int save(TableauBesoinItem tableauBesoinItem) {
        prepare(tableauBesoinItem);
//        tableauBesoinItem.getTableauBesoin().getExpressionBesoinItems().forEach(e->{
//            expressionBesoinItemService.update(e);
//        });
//        tableauBesoinItem.setTtc(tableauBesoinItem.getTableauBesoin().getTtc());
//        tableauBesoinItem.setTva(tableauBesoinItem.getTableauBesoin().getTva());
        tableauBesoinItem.setReference("t"+System.currentTimeMillis());
        tableauBesoinItemDao.save(tableauBesoinItem);
        return 1;
    }

    @Override
    public TableauBesoinItem findByReference(String reference) {
        return tableauBesoinItemDao.findByReference(reference);
    }

    @Override
    public List<TableauBesoinItem> findByTableauBesoinReference(String reference) {
        return tableauBesoinItemDao.findByTableauBesoinReference(reference);
    }

    @Override
    public List<TableauBesoinItem> findByStatut(String statut) {
        return tableauBesoinItemDao.findByStatut(statut);
    }

    private void prepare(TableauBesoinItem tableauBesoinItem) {
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(tableauBesoinItem.getFournisseur().getReferenceFournisseur());
        tableauBesoinItem.setFournisseur(fournisseur);
        TableauBesoin tableauBesoin = tableauBesoinService.findByReference(tableauBesoinItem.getTableauBesoin().getReference());
        tableauBesoinItem.setTableauBesoin(tableauBesoin);
    }


    @Autowired
    private TableauBesoinItemDao tableauBesoinItemDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private TableauBesoinService tableauBesoinService;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
}
