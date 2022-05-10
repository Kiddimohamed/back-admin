package com.example.backadmin.dao;

import com.example.backadmin.bean.ExpressionBesoinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionBesoinItemDao extends JpaRepository<ExpressionBesoinItem, Long> {

    List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    ExpressionBesoinItem findByCode(String code);
}
