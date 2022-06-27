package com.example.backadmin.service.facade;

import com.example.backadmin.bean.Employe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeService {
    Employe findByReferenceEmploye(String referenceEmploye);

    Employe findByNomEmploye(String nomEmploye);

    List<Employe> findByEtablissementReference(String reference);

    List<Employe> findAll();


    int save(Employe employe);



}
