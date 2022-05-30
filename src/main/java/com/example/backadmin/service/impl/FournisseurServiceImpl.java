package com.example.backadmin.service.impl;
import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.dao.FournisseurDao;
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
    public Fournisseur findByVilleFournisseur(String villeFournisseur) {
        return fournisseurDao.findByVilleFournisseur(villeFournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurDao.findAll();
    }

    @Override
    public int save(Fournisseur fournisseur){
        Fournisseur fournisseurLoaded = findByReferenceFournisseur(fournisseur.getReferenceFournisseur());
        if (fournisseurLoaded != null){
            return -1;
        }else{
            fournisseurDao.save(fournisseur);
            return 1;
        }
    }

    @Override
    public List<Fournisseur> findByTypeFournisseurReference(String reference) {
        return fournisseurDao.findByTypeFournisseurReference(reference);
    }

    @Autowired
    FournisseurDao fournisseurDao;
}
