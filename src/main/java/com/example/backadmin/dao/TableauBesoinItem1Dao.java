package com.example.backadmin.dao;

import com.example.backadmin.bean.TableauBesoinItem1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableauBesoinItem1Dao extends JpaRepository<TableauBesoinItem1,Long> {
    TableauBesoinItem1 findByReference(String reference);
    List<TableauBesoinItem1> findByExpressionBesoinItemCode(String code);
}
