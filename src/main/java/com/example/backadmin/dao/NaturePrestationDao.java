package com.example.backadmin.dao;

import com.example.backadmin.bean.Commande;
import com.example.backadmin.bean.NaturePrestation;
import org.bouncycastle.math.raw.Nat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaturePrestationDao extends JpaRepository<NaturePrestation,Long> {
    NaturePrestation findByReference(String reference);
    int deleteByReference(String reference);
    List<NaturePrestation> findByNaturePrestationTypeReference(String reference);

}
