package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ServiceDemandeur;

import java.util.List;

public interface ServiceDemandeurService {
    ServiceDemandeur findByReference(String reference);

    int deleteByReference(String ref);
//    ServiceDemandeur findByEtablissementReference(String reference);

    List<ServiceDemandeur> findAll();
    void updateService(ServiceDemandeur serviceDemandeur,String reference);

    int save(ServiceDemandeur serviceDemandeur);
}
