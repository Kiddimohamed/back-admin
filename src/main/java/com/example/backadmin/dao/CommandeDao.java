package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CommandeDao extends JpaRepository<Commande, Long> {

    Commande findByCode(String codeCommande);
    List<Commande> findByTableauBesoinItemReference(String reference);
    List<Commande> findByFournisseurReferenceFournisseur(String reference);
    List<Commande> findByRubriqueReference(String reference);
// todo find by other classes

//    List<Commande> findByServiceDemandeurReference(String reference);
//statistique
    @Query("SELECT COUNT(c.id) FROM Commande c WHERE 1=1")
    int getnbrOfCommande();

    @Query(value = "SELECT SUM(c.totalTtc) FROM Commande c WHERE c.month like :month ")
    String ttc_par_mois(@Param("month") String month);

}
//tot
