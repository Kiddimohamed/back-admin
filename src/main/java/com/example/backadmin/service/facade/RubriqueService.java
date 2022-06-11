package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Rubrique;

import java.util.List;

public interface RubriqueService {
    Rubrique findByReference(String reference);
    List<Rubrique> findAll();
    List<Rubrique> findByLigneLibelle(String ligneLibelle);

    int save(Rubrique rubrique);
}
