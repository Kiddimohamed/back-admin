package com.example.backadmin.service.facade;

import com.example.backadmin.bean.FaxType;

import java.util.List;

public interface FaxTypeService {
    FaxType findByCode(String code);

    FaxType findByLibelle(String libelle);

    List<FaxType> findAll();

    int save(FaxType faxType);
}
