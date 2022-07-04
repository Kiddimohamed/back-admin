package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
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
    public TableauBesoinItem save(TableauBesoinItem tableauBesoinItem) {
        prepare(tableauBesoinItem);
        tableauBesoinItem.setReference("t" + System.currentTimeMillis());

        tableauBesoinItemDao.save(tableauBesoinItem);
        return tableauBesoinItem;
    }

    @Override
    public TableauBesoinItem findByReference(String reference) {
        return tableauBesoinItemDao.findByReference(reference);
    }

    @Override
    public List<TableauBesoinItem> findByStatutAndTableauBesoinReference(String statut, String reference) {
        return tableauBesoinItemDao.findByStatutAndTableauBesoinReference(statut, reference);
    }


    @Override
    public List<TableauBesoinItem> findByTableauBesoinReference(String reference) {
        return tableauBesoinItemDao.findByTableauBesoinReference(reference);
    }

    @Override
    public List<TableauBesoinItem> findByStatut(String statut) {
        return tableauBesoinItemDao.findByStatut(statut);
    }

    @Override
    public List<TableauBesoinItem> findByTableauBesoinStatut(String statut) {
        return tableauBesoinItemDao.findByTableauBesoinStatut(statut);
    }


    @Override
    public TableauBesoinItem findByTableauBesoinReferenceAndFournisseurReferenceFournisseur(String tabRef, String fournisseurRef) {
        return tableauBesoinItemDao.findByTableauBesoinReferenceAndFournisseurReferenceFournisseur(tabRef, fournisseurRef);
    }


    private void prepare(TableauBesoinItem tableauBesoinItem) {
        Fournisseur fournisseur = fournisseurService.findByReferenceFournisseur(tableauBesoinItem.getFournisseur().getReferenceFournisseur());
        tableauBesoinItem.setFournisseur(fournisseur);
//        TableauBesoin tableauBesoin = tableauBesoinService.findByReference(tableauBesoinItem.getTableauBesoin().getReference());
//        tableauBesoinItem.setTableauBesoin(tableauBesoin);

    }

    @Override
    public void updateStatut(TableauBesoinItem tableauBesoinItem) {
        TableauBesoinItem tableauBesoinItem1 = tableauBesoinItemDao.findByReference(tableauBesoinItem.getReference());
        tableauBesoinItem1.setStatut(tableauBesoinItem.getStatut());
        tableauBesoinItem1.setHt(tableauBesoinItem.getHt());
        tableauBesoinItem1.setTtc(tableauBesoinItem.getTtc());
        tableauBesoinItem1.setTva(tableauBesoinItem.getTva());
        tableauBesoinItemDao.save(tableauBesoinItem1);
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
