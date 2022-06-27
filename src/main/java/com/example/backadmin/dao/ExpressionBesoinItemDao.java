package com.example.backadmin.dao;

import com.example.backadmin.bean.ExpressionBesoinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionBesoinItemDao extends JpaRepository<ExpressionBesoinItem, Long> {
    public List<ExpressionBesoinItem> findByExpressionBesoinObjet(String objet) ;
    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut);
//    List<ExpressionBesoinItem> findByTableauBesoinReference(String reference);
    List<ExpressionBesoinItem> findByStatut(String statut);
    List<ExpressionBesoinItem> findByRefExpr(String refExpr);
    ExpressionBesoinItem findByCode(String code);
    @Query("SELECT coalesce(max(expI.id), 0) FROM ExpressionBesoinItem expI")
    Long getMaxId();


}
