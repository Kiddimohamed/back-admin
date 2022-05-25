package com.example.backadmin.dao;

import com.example.backadmin.bean.ChapitreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapitreTypeDao extends JpaRepository<ChapitreType,Long> {
    ChapitreType findByReference(String reference);
    int deleteByReference(String reference);

}
