package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpressionBesoinService {
    ExpressionBesoin findByObjet(String objet);

    ExpressionBesoin findByReference(String reference);

    List<ExpressionBesoin> findByStatut(String statut);
//    List<ExpressionBesoin> findByUserReference(String reference);

    List<ExpressionBesoin> findAll();

    int save(ExpressionBesoin expressionBesoin);

    void saveNull(ExpressionBesoin expressionBesoin);
    int expressionBesoinEncours();
    public int getNumberOfExpressionBesoinEnAttente(); }

