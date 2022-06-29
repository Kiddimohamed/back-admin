package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.ExpressionBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpressionBesoinDao extends JpaRepository<ExpressionBesoin, Long> {

    ExpressionBesoin findByReference(String ref);

    ExpressionBesoin findByObjet(String objet);

    List<ExpressionBesoin> findByStatut(String statut);

    ExpressionBesoin findByDateExb(LocalDateTime date);

    List<ExpressionBesoin> findByUserReference(String ref);


    List<ExpressionBesoin> findByStatutAndUserUsername(String statut, String userName);

    int deleteByReference(String ref);


    List<ExpressionBesoin> findByNatureDemandeNom(String nom);



    @Query("SELECT coalesce(max(exp.id), 0) FROM ExpressionBesoin exp")
    Long getMaxId();
    //statistique
    @Query("SELECT COUNT(e.id) from ExpressionBesoin e WHERE e.statut='En attente'")
    int getNumberOfExpressionBesoinEnAttente();

    //get nbr of expressionBesoin By Month
    @Query(value = "SELECT count(e.id) FROM ExpressionBesoin e WHERE e.month like :month ")
    String exp_par_mois(@Param("month") String month);

}
