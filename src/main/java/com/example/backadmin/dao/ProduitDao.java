package com.example.backadmin.dao;

import com.example.backadmin.bean.Fournisseur;
import com.example.backadmin.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit,Long> {

    Produit findByLibelle(String libelle);
    Produit findByNumeroInventaire(String numeroInventaire);
    Produit findByCode(String code);
    @Query("SELECT coalesce(max(produit.id), 0) FROM Produit produit")
    Long getMaxId();

}
