package com.example.backadmin.dao;

import com.example.backadmin.bean.Fax;
import com.example.backadmin.bean.FaxType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaxTypeDao extends JpaRepository<FaxType, Long> {

    FaxType findByCode(String code);

    FaxType findByLibelle(String libelle);


}
