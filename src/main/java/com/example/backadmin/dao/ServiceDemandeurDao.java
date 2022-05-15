package com.example.backadmin.dao;

import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.ServiceDemandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDemandeurDao extends JpaRepository<ServiceDemandeur,Long> {
// void delete(ServiceDemandeur serviceDemandeur);

    int deleteByReference(String ref);

    ServiceDemandeur findByReference(String reference);
//    ServiceDemandeur findByEtablissementReference(String reference);

    void updateService(ServiceDemandeur serviceDemandeur,String reference);
}
