package com.example.backadmin.dao;

import com.example.backadmin.bean.ServiceDemandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDemandeurDao extends JpaRepository<ServiceDemandeur, Long> {
// void delete(ServiceDemandeur serviceDemandeur);

    void deleteByReference(String reference);

    ServiceDemandeur findByReference(String reference);
    ServiceDemandeur findByNom(String nom);

    //    ServiceDemandeur findByEtablissementReference(String reference);


}
