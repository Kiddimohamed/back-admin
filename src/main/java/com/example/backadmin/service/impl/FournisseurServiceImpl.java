package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.dao.FournisseurDao;
import com.example.backadmin.service.facade.FournisseurItemService;
import com.example.backadmin.service.facade.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Override
    public Fournisseur findByReferenceFournisseur(String referenceFournisseur) {
        return fournisseurDao.findByReferenceFournisseur(referenceFournisseur);
    }

    @Override
    public List<Fournisseur> findByStatut(String statut) {
        return fournisseurDao.findByStatut(statut);
    }

    @Override
    public Fournisseur findByVilleFournisseur(String villeFournisseur) {
        return fournisseurDao.findByVilleFournisseur(villeFournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurDao.findAll();
    }

    @Override
    public int save(Fournisseur fournisseur) {
//        FournisseurItem fournisseurItem=fournisseurItemService.findByReference(fournisseur.getFournisseurItem().getReference());
//        fournisseur.setFournisseurItem(fournisseurItem);
        fournisseur.setReferenceFournisseur("f_" + System.currentTimeMillis());
        Fournisseur fournisseurLoaded = findByReferenceFournisseur(fournisseur.getReferenceFournisseur());
        if (fournisseurLoaded != null) {
            return -1;
        } else {
            fournisseurDao.save(fournisseur);
            return 1;
        }
    }

    @Override
    public int updateRib(Fournisseur fournisseur) {
        Fournisseur fournisseur1 = findByReferenceFournisseur(fournisseur.getReferenceFournisseur());
        fournisseur1.setRib(fournisseur.getRib());
        fournisseurDao.save(fournisseur1);
        return 1;
    }

    @Override
    public int updateStatut(Fournisseur fournisseur) {
        Fournisseur fournisseur1 = findByReferenceFournisseur(fournisseur.getReferenceFournisseur());
        fournisseur1.setStatut(fournisseur.getStatut());
        fournisseurDao.save(fournisseur1);
        return 1;
    }

    @Autowired
    FournisseurDao fournisseurDao;
    @Autowired
    FournisseurItemService fournisseurItemService;
}
