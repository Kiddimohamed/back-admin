package com.example.backadmin.dao;

import com.example.backadmin.bean.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurDao  extends JpaRepository<Fournisseur,Long> {

    Fournisseur findByReferenceFournisseur(String reference);
    Fournisseur findByVilleFournisseur(String ville);
}
