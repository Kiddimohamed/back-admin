package com.example.backadmin.service.facade;

import com.example.backadmin.bean.NaturePrestation;

import java.util.List;

public interface NaturePrestationService {
    NaturePrestation findByReference(String reference);

    int deleteByReference(String reference);

    List<NaturePrestation> findByNaturePrestationTypeReference(String reference);

    List<NaturePrestation> findAll();

    int save(NaturePrestation naturePrestation);
}
