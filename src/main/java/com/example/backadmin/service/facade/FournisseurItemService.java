package com.example.backadmin.service.facade;

import com.example.backadmin.bean.FournisseurItem;

import java.util.List;

public interface FournisseurItemService {
    List<FournisseurItem> findByTypeFournisseurReference(String reference);

    List<FournisseurItem> findAll();
    FournisseurItem findByReference(String reference);

    FournisseurItem save(FournisseurItem fournisseurItem);
}
