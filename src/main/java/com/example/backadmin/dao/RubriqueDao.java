package com.example.backadmin.dao;

import com.example.backadmin.bean.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubriqueDao extends JpaRepository<Rubrique, Long> {
    Rubrique findByReference(String reference);
//todo Completer le

}
