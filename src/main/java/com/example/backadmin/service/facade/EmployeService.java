package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Employe;

import java.util.List;

public interface EmployeService {
    Employe findByReference(String reference);

    Employe findByNom(String nom);

    List<Employe> findByEtablissementReference(String reference);

    List<Employe> findAll();


    int save(Employe employe);
}
