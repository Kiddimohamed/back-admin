package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoinItem;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.jpa.repository.Query;

import java.io.FileNotFoundException;
import java.util.List;

public interface ExpressionBesoinItemService {
    ExpressionBesoinItem findByRef(String ref);

    int deleteByRef(String ref);

    void updatePrix(ExpressionBesoinItem expressionBesoinItem);

    List<ExpressionBesoinItem> findByExpressionBesoinStatut(String statut);
    List<ExpressionBesoinItem> findByExpressionBesoinObjet(String objet);
    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    List<ExpressionBesoinItem> findByStatut(String statut);

    List<ExpressionBesoinItem> findByTableauBesoinItemRef(String ref);

    List<ExpressionBesoinItem> findAll();
    ExpressionBesoinItem findByCode(String code);
    List<ExpressionBesoinItem> findByTableauBesoinReference(String reference);


    int updateStatut(ExpressionBesoinItem expressionBesoinItem);

    int updateTableauBesoin(ExpressionBesoinItem expressionBesoinItem);

    int save(ExpressionBesoinItem expressionBesoinItem);

    String imprimer(String objet) throws FileNotFoundException, JRException;


    Long getMaxId();

}
