package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ChapitreType;

import java.util.List;

public interface ChapitreTypeService {
    ChapitreType findByReference(String reference);

    int deleteByReference(String reference);

    List<ChapitreType> findAll();

    int save(ChapitreType chapitreType);
}
