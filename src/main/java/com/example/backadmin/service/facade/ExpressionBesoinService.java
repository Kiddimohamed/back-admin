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
    public int getNumberOfExpressionBesoinEnAttente();

    List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12);
}

