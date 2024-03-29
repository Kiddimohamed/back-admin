package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Chapitre;
import com.example.backadmin.bean.ChapitreType;
import com.example.backadmin.bean.Exercice;
import com.example.backadmin.dao.ChapitreDao;
import com.example.backadmin.service.facade.ChapitreService;
import com.example.backadmin.service.facade.ChapitreTypeService;
import com.example.backadmin.service.facade.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapitreServiceImpl implements ChapitreService {


    @Override
    public Chapitre findByReference(String reference) {
        return chapitreDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return chapitreDao.deleteByReference(reference);
    }

    @Override
    public List<Chapitre> findByChapitreTypeReference(String reference) {
        return chapitreDao.findByChapitreTypeReference(reference);
    }

    @Override
    public List<Chapitre> findByExerciceReference(String reference) {
        return chapitreDao.findByExerciceReference(reference);
    }

    @Override
    public List<Chapitre> findAll() {
        return chapitreDao.findAll();
    }

    @Override
    public  int save(Chapitre chapitre){
        Chapitre chapitre1=findByReference(chapitre.getReference());
        prepare(chapitre);
        if(chapitre1!=null){
            return -1;
        }else if (chapitre.getChapitreType()==null || chapitre.getExercice()==null){
            return -2;
        }else{
            chapitre.setLibelleExercice(chapitre.getExercice().getLibelle());
            chapitre.setLibelleType(chapitre.getChapitreType().getType());
            chapitreDao.save(chapitre);
            return 1;
        }
    }

    @Override
    public List<Chapitre> findByLibelleExercice(String libelle) {
        return chapitreDao.findByLibelleExercice(libelle);
    }

    private void prepare(Chapitre chapitre) {
        ChapitreType chapitreType= chapitreTypeService.findByReference(chapitre.getChapitreType().getReference());
        chapitre.setChapitreType(chapitreType);
        Exercice exercice=exerciceService.findByReference(chapitre.getExercice().getReference());
        chapitre.setExercice(exercice);
    }

    @Autowired
    ExerciceService exerciceService;
    @Autowired
    ChapitreDao chapitreDao;
    @Autowired
    ChapitreTypeService chapitreTypeService;
}
