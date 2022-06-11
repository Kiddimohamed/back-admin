package com.example.backadmin.dao;

import com.example.backadmin.bean.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubriqueDao extends JpaRepository<Rubrique, Long> {
    Rubrique findByReference(String reference);
    List<Rubrique> findByLigneLibelle(String ligneLibelle);
//todo Completer le

}
