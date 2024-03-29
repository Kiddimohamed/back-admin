package com.example.backadmin.service.facade;

import com.example.backadmin.bean.ServiceDemandeur;

import java.util.List;

public interface ServiceDemandeurService {
    ServiceDemandeur findByReference(String reference);
    ServiceDemandeur findByNom(String nom);

    void deleteByReference(String reference);
//    ServiceDemandeur findByEtablissementReference(String reference);

    List<ServiceDemandeur> findAll();
    void updateService(ServiceDemandeur serviceDemandeur,String nom);

    int save(ServiceDemandeur serviceDemandeur);
}
