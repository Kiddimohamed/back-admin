package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoinItem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpressionBesoinItemService {
    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);

    List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut);

    List<ExpressionBesoinItem> findAll();

    List<ExpressionBesoinItem> findByTableauBesoinReference(String reference);
    List<ExpressionBesoinItem> findByRefExpr(String refExpr);

    int update(ExpressionBesoinItem expressionBesoinItem);

    ExpressionBesoinItem findByCode(String code);

    @Query("SELECT coalesce(max(exp.id), 0) FROM ExpressionBesoin exp")
    Long getMaxId();

    int save(ExpressionBesoinItem expressionBesoinItem);

    List<ExpressionBesoinItem> findByStatut(String statut);

}
