package com.example.backadmin.dao;

import com.example.backadmin.bean.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapitreDao extends JpaRepository<Chapitre,Long> {
    Chapitre findByReference(String reference);
    int deleteByReference(String reference);
    List<Chapitre> findByChapitreTypeReference(String reference);
    List<Chapitre> findByExerciceReference(String reference);
    List<Chapitre> findByLibelleExercice(String libelle);

}
