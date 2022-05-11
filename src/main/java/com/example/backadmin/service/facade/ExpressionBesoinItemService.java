package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoinItem;

import java.util.List;

public interface ExpressionBesoinItemService {
    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);

    List<ExpressionBesoinItem> findAll();

    ExpressionBesoinItem findByCode(String code);

    int save(ExpressionBesoinItem expressionBesoinItem);

    Long getMaxId();
}
