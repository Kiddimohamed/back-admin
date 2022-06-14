package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.FournisseurItem;
import com.example.backadmin.bean.TypeFournisseur;
import com.example.backadmin.dao.FournisseurItemDao;
import com.example.backadmin.service.facade.FournisseurItemService;
import com.example.backadmin.service.facade.FournisseurService;
import com.example.backadmin.service.facade.TypeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoournisseurItemServiceImpl implements FournisseurItemService {
    @Autowired
    private FournisseurItemDao fournisseurItemDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private TypeFournisseurService typeFournisseurService;

    @Override
    public List<FournisseurItem> findByTypeFournisseurReference(String reference) {
        return fournisseurItemDao.findByTypeFournisseurReference(reference);
    }

    @Override
    public List<FournisseurItem> findAll() {
        return fournisseurItemDao.findAll();
    }

    @Override
    public FournisseurItem findByReference(String reference) {
        return fournisseurItemDao.findByReference(reference);
    }

    @Override
    public FournisseurItem save(FournisseurItem fournisseurItem) {
        fournisseurService.save(fournisseurItem.getFournisseur());
        Fournisseur fournisseur=fournisseurService.findByReferenceFournisseur(fournisseurItem.getFournisseur().getReferenceFournisseur());
        fournisseurItem.setFournisseur(fournisseur);
        TypeFournisseur typeFournisseur=typeFournisseurService.findByReference(fournisseurItem.getTypeFournisseur().getReference());
        fournisseurItem.setTypeFournisseur(typeFournisseur);
        return fournisseurItemDao.save(fournisseurItem);
    }
}
