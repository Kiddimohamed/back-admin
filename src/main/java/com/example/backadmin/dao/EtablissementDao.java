package com.example.backadmin.dao;

import com.example.backadmin.bean.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementDao extends JpaRepository<Etablissement, Long> {

    Etablissement findByReference(String reference);
    Etablissement findByVille(String ville);
}
