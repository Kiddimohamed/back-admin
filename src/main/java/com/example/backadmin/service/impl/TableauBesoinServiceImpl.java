package com.example.backadmin.service.impl;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.dao.TableauBesoinDao;
import com.example.backadmin.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauBesoinServiceImpl implements TableauBesoinService {
    @Override
    public TableauBesoin save(TableauBesoin tableauBesoin) {
//        Fournisseur fournisseur=fournisseurService.findByReferenceFournisseur(tableauBesoin.getFournisseur().getReferenceFournisseur());
//        tableauBesoin.setFournisseur(fournisseur);

        tableauBesoin.setReference("tab_" + System.currentTimeMillis());
        tableauBesoinDao.save(tableauBesoin);
        tableauBesoin.getExpressionBesoinItems().forEach(e -> {
            e.setTableauBesoin(tableauBesoin);
            expressionBesoinItemService.updateTableauBesoin(e);
        });
        List<TableauBesoinItem> tableauBesoinItems=tableauBesoinItemService.findByStatut("x");
       tableauBesoinItems.forEach(t -> {
           TableauBesoinItem tab=tableauBesoinItemService.findByReference(t.getReference());
            tab.setTableauBesoin(tableauBesoin);
            tab.setStatut("en attente");
            tableauBesoinItemService.save(tab);
            emailSenderService.sendMail(t.getFournisseur().getEmailFournisseur(), t.getReference());
           tableauBesoin.getExpressionBesoinItems().forEach(e -> {
               e.setStatut("envoyee");
               expressionBesoinItemService.updateStatut(e);
           });

        });
//        tableauBesoin.setReference("t1"+tableauBesoin.getReference());
        return tableauBesoin;
    }


    @Override
    public void update(TableauBesoin tableauBesoin, String statut) {
        TableauBesoin tableauBesoin1 = tableauBesoinDao.findByReference(tableauBesoin.getReference());
        tableauBesoin1.setStatut(statut);
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
    private TableauBesoinItemService tableauBesoinItemService;
    @Autowired
    private TableauBesoinDao tableauBesoinDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private ExpressionBesoinItemService expressionBesoinItemService;
    @Autowired
    private EmailSenderService emailSenderService;
}
