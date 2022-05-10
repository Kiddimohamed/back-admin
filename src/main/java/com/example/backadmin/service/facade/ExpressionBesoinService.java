package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoin;

import java.util.List;

public interface ExpressionBesoinService {
    ExpressionBesoin findByObjet(String objet);

    ExpressionBesoin findByReference(String reference);

    List<ExpressionBesoin> findByEmployeReference(String reference);

    List<ExpressionBesoin> findByServiceDemandeurReference(String reference);

    List<ExpressionBesoin> findAll();

    int save(ExpressionBesoin expressionBesoin);
}
