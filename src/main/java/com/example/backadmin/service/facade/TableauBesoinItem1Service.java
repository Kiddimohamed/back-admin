package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoinItem1;

import java.util.List;

public interface TableauBesoinItem1Service {
    TableauBesoinItem1 findByReference(String reference);
    List<TableauBesoinItem1> findAll();
    List<TableauBesoinItem1> findByExpressionBesoinItemCode(String code);


    void update(TableauBesoinItem1 tableauBesoinItem);

    int save(TableauBesoinItem1 tableauBesoinItem);
}
