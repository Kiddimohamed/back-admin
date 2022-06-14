package com.example.backadmin.dao;

import com.example.backadmin.bean.FournisseurItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurItemDao extends JpaRepository<FournisseurItem,Long> {
    List<FournisseurItem> findAll();
    List<FournisseurItem> findByTypeFournisseurReference(String reference);
    FournisseurItem findByReference(String reference);
}
