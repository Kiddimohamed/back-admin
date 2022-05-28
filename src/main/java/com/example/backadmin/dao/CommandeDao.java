package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {

    Commande findByCode(String codeCommande);
    List<Commande> findByExpressionBesoinReference(String reference);
//    List<Commande> findByServiceDemandeurReference(String reference);

}
//tot
