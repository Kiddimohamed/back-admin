package com.example.backadmin.dao;

import com.example.backadmin.bean.NatureDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatureDemandeDao extends JpaRepository<NatureDemande, Long> {
    NatureDemande findByRef(String reference);
    NatureDemande findByNom(String nom);

    List<NatureDemande> findAll();
    int deleteByRef(String reference);
    int deleteByNom (String nom);
}
