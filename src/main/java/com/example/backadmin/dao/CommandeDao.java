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
    List<Commande> findByFournisseurReferenceFournisseur(String reference);
    List<Commande> findByLigneReference(String reference);
    List<Commande> findByNaturePrestationReference(String reference);
    List<Commande> findByChapitreReference(String reference);
    List<Commande> findByArticleReference(String reference);
    List<Commande> findByParagrapheReference(String reference);
//    List<Commande> findByServiceDemandeurReference(String reference);

}
//tot
