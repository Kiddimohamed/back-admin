package com.example.backadmin.dao;

import com.example.backadmin.bean.Produit;
import com.example.backadmin.bean.ServiceDemandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDemandeurDao extends JpaRepository<ServiceDemandeur,Long> {

    ServiceDemandeur findByReference(String reference);
    ServiceDemandeur findByEtablissementReference(String reference);


}
