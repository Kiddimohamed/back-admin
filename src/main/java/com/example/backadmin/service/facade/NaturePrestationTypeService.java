package com.example.backadmin.service.facade;

import com.example.backadmin.bean.NaturePrestationType;

import java.util.List;

public interface NaturePrestationTypeService {
    NaturePrestationType findByReference(String reference);

    int deleteByReference(String reference);

    List<NaturePrestationType> findAll();

    int save(NaturePrestationType naturePrestationType);
}
