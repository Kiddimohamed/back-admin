package com.example.backadmin.dao;

import com.example.backadmin.bean.Employe;
import com.example.backadmin.bean.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {

    Employe findByReference(String reference);
    Employe findByNom(String nom);
    List<Employe> findByEtablissementReference(String reference);


}
