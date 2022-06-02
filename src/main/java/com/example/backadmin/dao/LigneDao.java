package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneDao extends JpaRepository<Ligne,Long> {
    Ligne findByReference(String reference);
    int deleteByReference(String reference);
    List<Ligne> findByNaturePrestationReference(String reference);
    List<Ligne> findByParagrapheReference(String reference);

    //todo find by AND to all Dao

}
