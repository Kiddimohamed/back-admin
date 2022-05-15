package com.example.backadmin.service.impl;

import com.example.backadmin.bean.Etablissement;
import com.example.backadmin.bean.ServiceDemandeur;
import com.example.backadmin.dao.ServiceDemandeurDao;
import com.example.backadmin.service.facade.EtablissementService;
import com.example.backadmin.service.facade.ServiceDemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceDemandeurServiceImpl implements ServiceDemandeurService {
    @Override
    public ServiceDemandeur findByReference(String reference) {
        return serviceDemandeurDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String ref) {
        return 0;
    }


//    @Override
//    public ServiceDemandeur findByEtablissementReference(String reference) {
//        return serviceDemandeurDao.findByEtablissementReference(reference);
//    }

    @Override
    public List<ServiceDemandeur> findAll() {
        return serviceDemandeurDao.findAll();
    }

    @Override
    public void updateService(ServiceDemandeur serviceDemandeur,String reference) {
        ServiceDemandeur service=serviceDemandeurDao.findByReference(serviceDemandeur.getReference());
        service.setReference(reference);
//        serviceDemandeurDao.save(service);

    }

    @Override
    public int save(ServiceDemandeur serviceDemandeur) {
        ServiceDemandeur serviceDemandeur1 = findByReference(serviceDemandeur.getReference());
//        Etablissement etablissement1 = etablissementService.findByReference(serviceDemandeur.getEtablissement().getReference());
//        serviceDemandeur.setEtablissement(etablissement1);

        if (serviceDemandeur1 != null) {
            return -1;
        } else {
            serviceDemandeurDao.save(serviceDemandeur);
            return 1;
        }
    }

    @Autowired
    EtablissementService etablissementService;
    @Autowired
    ServiceDemandeurDao serviceDemandeurDao;
}
