package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Produit;

import java.util.List;

public interface ProduitService {
    Produit findByLibelle(String libelle);

    Produit findByNumeroInventaire(String numeroInventaire);

    Produit findByCode(String code);

    List<Produit> findAll();

    int save(Produit produit);

    Long getMaxId();
}
