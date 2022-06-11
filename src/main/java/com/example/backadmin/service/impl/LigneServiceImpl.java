package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Ligne;
import com.example.backadmin.bean.NaturePrestation;
import com.example.backadmin.bean.Paragraphe;
import com.example.backadmin.dao.LigneDao;
import com.example.backadmin.service.facade.LigneService;
import com.example.backadmin.service.facade.NaturePrestationService;
import com.example.backadmin.service.facade.ParagrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LigneServiceImpl implements LigneService {

    @Override
    public Ligne findByReference(String reference) {
        return ligneDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return ligneDao.deleteByReference(reference);
    }

    @Override
    public List<Ligne> findByNaturePrestationReference(String reference) {
        return ligneDao.findByNaturePrestationReference(reference);
    }

    @Override
    public List<Ligne> findByLibelleParagraphe(String libelleParagraphe) {
        return ligneDao.findByLibelleParagraphe(libelleParagraphe);
    }

    @Override
    public List<Ligne> findByParagrapheReference(String reference) {
        return ligneDao.findByParagrapheReference(reference);
    }

    @Override
    public List<Ligne> findAll() {
        return ligneDao.findAll();
    }

    @Override
    public int save(Ligne ligne) {
        Ligne ligne1 = findByReference(ligne.getReference());
        prepare(ligne);
        if (ligne1 != null) {
            return -1;
        } else if (ligne.getParagraphe() == null ) {
            return -3;

        }else if(ligne.getNaturePrestation() == null) {
          return -4;
        } else {
            ligne.setLibelleArticle(ligne.getParagraphe().getLibelleArticle());
            ligne.setLibelleChapitre(ligne.getParagraphe().getLibelleChapitre());
            ligne.setLibelleParagraphe(ligne.getParagraphe().getLibellePara());
            ligne.setCodeNaturePrestation(ligne.getNaturePrestation().getLibelle());
            ligneDao.save(ligne);
            return 1;
        }
    }

    private void prepare(Ligne ligne) {
        Paragraphe paragraphe = paragrapheService.findByReference(ligne.getParagraphe().getReference());
        ligne.setParagraphe(paragraphe);
        NaturePrestation naturePrestation = naturePrestationService.findByReference(ligne.getNaturePrestation().getReference());
        ligne.setNaturePrestation(naturePrestation);
    }

    @Autowired
    NaturePrestationService naturePrestationService;
    @Autowired
    ParagrapheService paragrapheService;
    @Autowired
    LigneDao ligneDao;
}
