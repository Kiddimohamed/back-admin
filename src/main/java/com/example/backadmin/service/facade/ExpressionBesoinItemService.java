package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoinItem;

import java.util.List;

public interface ExpressionBesoinItemService {
    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut);

    List<ExpressionBesoinItem> findAll();

    ExpressionBesoinItem findByCode(String code);

    int save(ExpressionBesoinItem expressionBesoinItem);
    List<ExpressionBesoinItem> findByStatut(String statut);

    Long getMaxId();
}
