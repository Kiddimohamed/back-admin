package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoin;
import com.example.backadmin.bean.TableauBesoinItem;

import java.util.List;

public interface TableauBesoinService {

    TableauBesoin save(TableauBesoin tableauBesoin);

    void update(TableauBesoin tableauBesoin, String statut);

    TableauBesoin findByReference(String reference);
    List<TableauBesoin> findAll();
    List<TableauBesoin> findByStatut(String statut);

}
