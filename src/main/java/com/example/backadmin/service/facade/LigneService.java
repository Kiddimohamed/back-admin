package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Ligne;

import java.util.List;

public interface LigneService {
    Ligne findByReference(String reference);

    int deleteByReference(String reference);

    List<Ligne> findByNaturePrestationReference(String reference);

    List<Ligne> findByParagrapheReference(String reference);

    List<Ligne> findAll();

    int save(Ligne ligne);
}
