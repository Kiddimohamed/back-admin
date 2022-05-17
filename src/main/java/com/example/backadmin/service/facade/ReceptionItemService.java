package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ReceptionItem;

import java.util.List;

public interface ReceptionItemService {
    ReceptionItem findByReferenceReceptionItem(String reference);

    List<ReceptionItem> findByReceptionReferenceReception(String referenceReception);

    List<ReceptionItem> findAll();
}
