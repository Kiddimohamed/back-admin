package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Fax;

import java.util.List;

public interface FaxService {
    Fax findByReferenceFax(String reference);

    Fax findByExpressionBesoinReference(String reference);

    List<Fax> findByFournisseurReferenceFournisseur(String referenceFournisseur);

    List<Fax> findByFaxTypeCode(String code);

    List<Fax> findAll();

    int save(Fax fax);
}
