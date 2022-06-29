package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpressionBesoinService {
    ExpressionBesoin findByReference(String reference);

    ExpressionBesoin findByObjet(String objet);

    ExpressionBesoin findByDateExb(LocalDateTime date);

    List<ExpressionBesoin> findByUserReference(String ref);

    int deleteByReference(String reference);

    List<ExpressionBesoin> findAll();

    List<ExpressionBesoin> findByStatutAndUserUsername(String statut,String userName);

    List<ExpressionBesoin> findByStatut(String statut);


    int save(ExpressionBesoin expressionBesoin);

    String getRefExpressionBesoin(ExpressionBesoin expressionBesoin);
//    void updateExpressionBesoin(String statut,ExpressionBesoin expressionBesoin);

    public void updateExpressionBesoin(ExpressionBesoin expressionBesoin);

    public void refuser(ExpressionBesoin expressionBesoin);
    int getNumberOfExpressionBesoinEnAttente();


    List<ExpressionBesoin> findByNatureDemandeNom(String nom);

    List<BigDecimal> getNumbersOrderByMonth(String month);
    List<String> graph_monsuel(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String e10, String e11, String e12);

//statistique

}