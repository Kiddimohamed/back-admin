package com.example.backadmin.dao;

import com.example.backadmin.bean.Fax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaxDao extends JpaRepository<Fax, Long> {

    Fax findByReference(String reference);

    Fax findByExpressionBesoinReference(String reference);

    List<Fax> findByFournisseurReference(String reference);

    List<Fax> findByFaxTypeCode(String code);
}
