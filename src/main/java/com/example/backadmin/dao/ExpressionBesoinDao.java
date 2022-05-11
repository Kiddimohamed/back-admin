package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.ExpressionBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionBesoinDao extends JpaRepository<ExpressionBesoin, Long> {

    ExpressionBesoin findByObjet(String objet);
    ExpressionBesoin findByReference(String reference);
    List<ExpressionBesoin> findByServiceDemandeurReference(String reference);
    @Query("SELECT coalesce(max(exp.id), 0) FROM ExpressionBesoin exp")
    Long getMaxId();
}
