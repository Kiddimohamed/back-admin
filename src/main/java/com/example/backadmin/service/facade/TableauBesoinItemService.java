package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoinItem;

import java.util.List;

public interface TableauBesoinItemService {
    int save(TableauBesoinItem tableauBesoinItem);
    TableauBesoinItem findByReference(String reference);
    List<TableauBesoinItem> findByTableauBesoinReference(String reference);
    List<TableauBesoinItem> findByStatut(String statut);

}
