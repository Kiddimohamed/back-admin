package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TypeFournisseur;

import java.util.List;

public interface TypeFournisseurService {
    TypeFournisseur findByReference(String reference);
    TypeFournisseur findByType(String type);
    List<TypeFournisseur> findAll();
    int save(TypeFournisseur typeFournisseur);
}
