package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoin;

import java.util.List;

public interface TableauBesoinService {
    void save(TableauBesoin tableauBesoin);

    void update(TableauBesoin tableauBesoin);

    TableauBesoin findByReference(String reference);
    List<TableauBesoin> findAll();
    List<TableauBesoin> findByStatut(String statut);

}
