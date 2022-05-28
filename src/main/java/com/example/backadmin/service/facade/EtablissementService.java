package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Etablissement;

import java.util.List;

public interface EtablissementService {

    Etablissement findByReference(String reference);

    Etablissement findByVille(String ville);

    List<Etablissement> findAll();

    int save(Etablissement etablissement);
}
