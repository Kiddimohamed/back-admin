package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Ligne;
import com.example.backadmin.bean.Rubrique;
import com.example.backadmin.dao.RubriqueDao;
import com.example.backadmin.service.facade.LigneService;
import com.example.backadmin.service.facade.RubriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubriqueServiceImpl implements RubriqueService {

    @Override
    public Rubrique findByReference(String reference) {
        return rubriqueDao.findByReference(reference);
    }

    @Override
    public List<Rubrique> findAll() {
        return rubriqueDao.findAll();
    }

    @Override
    public List<Rubrique> findByLigneLibelle(String ligneLibelle) {
        return rubriqueDao.findByLigneLibelle(ligneLibelle);
    }

    @Override
    public int save(Rubrique rubrique) {
        Rubrique rubrique1 = findByReference(rubrique.getReference());
        prepare(rubrique);
        if (rubrique1 != null) {
            return -1;
        } else {
            rubrique.setCodeArticle(rubrique.getLigne().getLibelleArticle());
            rubrique.setCodeLigne(rubrique.getLigne().getLibelle());
            rubrique.setCodeParagraphe(rubrique.getLigne().getLibelleParagraphe());
            rubrique.setLibelleLigne(rubrique.getLigne().getLibelle());
            rubriqueDao.save(rubrique);
            return 1;
        }
    }

    private void prepare(Rubrique rubrique) {
        Ligne ligne = ligneService.findByReference(rubrique.getLigne().getReference());
        rubrique.setLigne(ligne);
    }


    //todo rncapsulation services

    @Autowired
    LigneService ligneService;
    @Autowired
    RubriqueDao rubriqueDao;
}
