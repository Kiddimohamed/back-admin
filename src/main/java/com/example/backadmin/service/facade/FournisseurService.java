package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur findByReference(String reference);

    Fournisseur findByVille(String ville);

    List<Fournisseur> findAll();

    int save(Fournisseur fournisseur);
}
