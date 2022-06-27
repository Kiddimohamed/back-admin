package com.example.backadmin.service.impl;


import com.example.backadmin.bean.NatureDemande;
import com.example.backadmin.dao.NatureDemandeDao;
import com.example.backadmin.service.facade.NatureDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureDemandeServiceImpl implements NatureDemandeService {
 @Autowired
 NatureDemandeDao natureDemandeDao;

    @Override
    public NatureDemande findByRef(String reference) {
        return natureDemandeDao.findByRef(reference);
    }

    @Override
    public NatureDemande findByNom(String nom) {
        return natureDemandeDao.findByNom(nom);
    }

    @Override
    public List<NatureDemande> findAll() {
        return natureDemandeDao.findAll();
    }

    @Override
    public int deleteByRef(String reference) {
        return natureDemandeDao.deleteByRef(reference);
    }

    @Override
    public int deleteByNom(String nom) {
        return natureDemandeDao.deleteByNom(nom);
    }

    @Override
   public int save(NatureDemande natureDemande) {
        natureDemandeDao.save(natureDemande);
        return 1;

    }
}