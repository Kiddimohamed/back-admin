package com.example.backadmin.dao;

import com.example.backadmin.bean.NaturePrestationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturePrestationTypeDao extends JpaRepository<NaturePrestationType,Long> {
    NaturePrestationType findByReference(String reference);
    int deleteByReference(String reference);

}
