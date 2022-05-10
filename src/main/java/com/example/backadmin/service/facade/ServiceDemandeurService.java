package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ServiceDemandeur;

import java.util.List;

public interface ServiceDemandeurService {
    ServiceDemandeur findByReference(String reference);

    ServiceDemandeur findByEtablissementReference(String reference);

    List<ServiceDemandeur> findAll();

    int save(ServiceDemandeur serviceDemandeur);
}
