package com.example.backadmin.dao;

import com.example.backadmin.bean.TypeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFournisseurDao extends JpaRepository<TypeFournisseur,Long> {
    TypeFournisseur findByReference(String reference);
    TypeFournisseur findByType(String type);
}
