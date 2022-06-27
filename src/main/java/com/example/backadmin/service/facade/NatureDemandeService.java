package com.example.backadmin.service.facade;


import com.example.backadmin.bean.NatureDemande;

import java.util.List;

public interface NatureDemandeService {

    NatureDemande findByRef(String reference);

    NatureDemande findByNom(String nom);

    List<NatureDemande> findAll();

    int deleteByRef(String reference);

    int deleteByNom(String nom);

    int save(NatureDemande natureDemande);
}
