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
    public Fournisseur findByReference(String reference) {
        return fournisseurDao.findByReference(reference);
    }

    @Override
    public Fournisseur findByVille(String ville) {
        return fournisseurDao.findByVille(ville);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurDao.findAll();
    }

    @Override
    public int save(Fournisseur fournisseur){
        Fournisseur fournisseurLoaded = findByReference(fournisseur.getReference());
        if (fournisseurLoaded != null){
            return -1;
        }else{
            fournisseurDao.save(fournisseur);
            return 1;
        }
    }

    @Autowired
    FournisseurDao fournisseurDao;
}
