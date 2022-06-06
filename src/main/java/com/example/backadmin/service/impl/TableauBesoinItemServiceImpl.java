package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;
import com.example.backadmin.dao.TableauBesoinItemDao;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TableauBesoinItemService;
import com.example.backadmin.service.facade.TableauBesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableauBesoinItemServiceImpl implements TableauBesoinItemService {
    @Override
    public int save(TableauBesoinItem tableauBesoinItem) {
        prepare(tableauBesoinItem);
        tableauBesoinItemDao.save(tableauBesoinItem);
        return 0;
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
}
