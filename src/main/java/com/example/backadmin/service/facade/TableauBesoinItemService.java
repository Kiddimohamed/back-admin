package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ExpressionBesoinItem;
import com.example.backadmin.bean.TableauBesoinItem;

import java.util.List;

public interface TableauBesoinItemService {
    TableauBesoinItem findByReference(String reference);
    List<TableauBesoinItem> findAll();
    List<TableauBesoinItem> findByExpressionBesoinItemCode(String code);


    void update(TableauBesoinItem tableauBesoinItem);

    int save(TableauBesoinItem tableauBesoinItem);
}
