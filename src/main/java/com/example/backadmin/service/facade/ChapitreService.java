package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Chapitre;

import java.util.List;

public interface ChapitreService {
    Chapitre findByReference(String reference);

    int deleteByReference(String reference);

    List<Chapitre> findByChapitreTypeReference(String reference);

    List<Chapitre> findByExerciceReference(String reference);

    List<Chapitre> findAll();

    int save(Chapitre chapitre);
    List<Chapitre> findByLibelleExercice(String libelle);

}
